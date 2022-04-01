package com.edu.nju.clockcourier.task;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CalcTask {

    private static final Double minimumConfidence = 0.5;

    private final MvnDataService mvnDataService;
    private final MigrationDataService migrationDataService;
    private final HashMap<Pair<Integer, Integer>, List<Pair<Integer, String>>> rules;

    @Autowired
    public CalcTask(MvnDataService mvnDataService, MigrationDataService migrationDataService) {
        this.mvnDataService = mvnDataService;
        this.migrationDataService = migrationDataService;
        // (fromId, toId) -> [(projectId, version)]
        this.rules = new HashMap<>();
    }

    private List<Integer> removedDep(List<Integer> before, List<Integer> after) {
        List<Integer> res = new ArrayList<>();
        for (Integer cur : before) {
            if (after.contains(cur)) continue;
            res.add(cur);
        }
        return res;
    }

    private List<Integer> addedDep(List<Integer> before, List<Integer> after) {
        List<Integer> res = new ArrayList<>();
        for (Integer cur : after) {
            if (before.contains(cur)) continue;
            res.add(cur);
        }
        return res;
    }

    private void addRule(List<Integer> rem, List<Integer> add, Pair<Integer, String> curProj) {
        if (rem == null || add == null) return;
        for (Integer curRem : rem) {
            for (Integer curAdd : add) {
                // one migration rule
                Pair<Integer, Integer> curRule = Pair.of(curRem, curAdd);
                if (rules.containsKey(curRule)) {
                    rules.get(curRule).add(curProj);
                } else {
                    List<Pair<Integer, String>> list = new ArrayList<>();
                    list.add(curProj);
                    rules.put(curRule, list);
                }
            }
        }
    }

    private void extractOnce(List<MvnProjPO> group) {
        int len = group.size();
        if (len < 2) throw new RuntimeException("Group size is less than 2");
        for (int i = 1; i < len; ++i) {
            MvnProjPO before = group.get(i - 1);
            MvnProjPO after = group.get(i);
            List<Integer> beforeDep = this.mvnDataService
                    .allMvnDeps(before.getProjectId(), before.getVersion())
                    .stream()
                    .map(MvnDepPO::getLibId)
                    .collect(Collectors.toList());
            List<Integer> afterDep = this.mvnDataService
                    .allMvnDeps(after.getProjectId(), after.getVersion())
                    .stream()
                    .map(MvnDepPO::getLibId)
                    .collect(Collectors.toList());
            List<Integer> rem = this.removedDep(beforeDep, afterDep);
            List<Integer> add = this.addedDep(beforeDep, afterDep);
            this.addRule(rem, add, Pair.of(after.getProjectId(), after.getVersion()));
        }
    }

    private void extractAll() {
        // 获取所有有多个版本的项目
        List<MvnProjPO> all = this.mvnDataService.allMvnProjWithMultiVersions();
        int allLen = all.size();
        if (allLen == 0) return;
        List<MvnProjPO> one = new ArrayList<>();
        Integer tarId = all.get(0).getProjectId();
        for (int i = 0; i < allLen; ++i) {
            MvnProjPO cur = all.get(i);
            Integer curId = cur.getProjectId();
            if (curId.equals(tarId)) {
                one.add(cur);
                if (i != allLen - 1) continue;
            }
            // 以所有有相同 projectId 的项目为单位进行规则抽取
            System.out.println("Extracting: " + String.valueOf(curId));
            this.extractOnce(one);
            if (i == allLen - 1) break;
            one.clear();
            one.add(cur);
            tarId = curId;
        }
    }

    private Pair<Integer, Integer> ruleNumWithSpecificStartAndEnd(Integer start, Integer end) {
        Set<Pair<Integer, Integer>> all = this.rules.keySet();
        int numStart = 0, numEnd = 0;
        for (Pair<Integer, Integer> rule : all) {
            int curSize = this.rules.get(rule).size();
            if (rule.getFirst().equals(start)) numStart += curSize;
            if (rule.getSecond().equals(end)) numEnd += curSize;
        }
        return Pair.of(numStart, numEnd);
    }

    private void calculateAndStoreAll() {
        Set<Pair<Integer, Integer>> keys = this.rules.keySet();
        for (Pair<Integer, Integer> key : keys) {
            System.out.println("Calculating: from: " + String.valueOf(key.getFirst()) + ", to: " + String.valueOf(key.getSecond()));
            List<Pair<Integer, String>> revisions = this.rules.get(key);
            double up = (double) revisions.size();
            Pair<Integer, Integer> below = this.ruleNumWithSpecificStartAndEnd(key.getFirst(), key.getSecond());
            double left = up / below.getFirst();
            double right = up / below.getSecond();
            double confidence = Math.min(left, right);
            // if (confidence < CalcTask.minimumConfidence) continue;
            // 存入数据库
            for (Pair<Integer, String> revision : revisions) {
                MigrationRulePO po = new MigrationRulePO();
                po.setFromId(key.getFirst());
                po.setToId(key.getSecond());
                po.setConfidence(confidence);
                po.setProjectId(revision.getFirst());
                po.setVersion(revision.getSecond());
                this.migrationDataService.insertRuleIfNotExists(po);
            }
        }
    }

    public void process() {
        rules.clear();
        System.out.println("Start extracting all");
        this.extractAll();
        System.out.println("Extracting finished");
        System.out.println("Start calculating confidence");
        this.calculateAndStoreAll();
    }

}
