package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.DisplayConfig;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dao.MigrationRuleDataService;
import com.edu.nju.clockcourier.dao.RuleInstanceDataService;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.RuleInstancePO;
import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MigrationServiceImpl implements MigrationService {

    private final MvnService mvnService;
    private final MigrationRuleDataService migrationRuleDataService;
    private final RuleInstanceDataService ruleInstanceDataService;
    private final DisplayConfig config;

    @Autowired
    public MigrationServiceImpl(MvnService mvnService,
                                MigrationRuleDataService migrationRuleDataService,
                                RuleInstanceDataService ruleInstanceDataService,
                                DisplayConfig config) {
        this.mvnService = mvnService;
        this.migrationRuleDataService = migrationRuleDataService;
        this.ruleInstanceDataService = ruleInstanceDataService;
        this.config = config;
    }

    @Override
    public List<MigrationNodeVO> getMigrationGraph(Integer libId) {
        // 返回图中所有点的列表
        List<MigrationNodeVO> res = new ArrayList<>();
        Set<Integer> hasVisited = new HashSet<>();
        Queue<Integer> idQueue = new ArrayDeque<>();
        idQueue.add(libId);
        // 遍历所有候选 lib, 也就是图中所有点
        while (!idQueue.isEmpty()) {
            Integer curId = idQueue.remove();
            // 如果已经访问过, 直接跳过
            if (hasVisited.contains(curId)) continue;
            // 加入已经访问的集合
            hasVisited.add(curId);
            // 当前 lib 的信息
            MvnLibVO libInfo = this.mvnService.getSpecificMvnLib(curId);
            // 所有从当前 lib 可以迁移到的库信息
            List<MigrationRulePO> rules = this.migrationRuleDataService
                    .rulesWithSpecificStart(curId);
            for (MigrationRulePO rule : rules) {
                // 加入待访问列表
                idQueue.add(rule.getToId());
                // 将构造成的 node 加入结果集
                res.add(MigrationNodeVO.build(libInfo, rules.stream()
                        .map(MigrationRuleVO::build)
                        .collect(Collectors.toList())));
            }
        }
        return res;
    }

    @Override
    public MigrationRuleVO getRule(Integer ruleId) {
        MigrationRulePO po = this.migrationRuleDataService.getRule(ruleId);
        if (MigrationRulePO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchRuleExp.getMsg());
        return MigrationRuleVO.build(po);
    }

    @Override
    public MigrationInstanceListVO getInstance(Integer ruleId, Integer page) {
        // 根据 ruleId 获取迁移规则实例列表
        Pair<List<RuleInstancePO>, Integer> info = ruleInstanceDataService
                .getRelativeInstance(ruleId, page, Integer.parseInt(config.getPageSize()));
        // 每条迁移实例添加上 project 信息
        List<MigrationInstanceVO> list = info.getFirst()
                .stream()
                .map(c -> {
                    MvnProjectVO project = this.mvnService.getMvnProject(c.getProjectId());
                    return MigrationInstanceVO.build(c, project);
                })
                .collect(Collectors.toList());
        return new MigrationInstanceListVO(config.pageAll(info.getSecond()), list);
    }

}
