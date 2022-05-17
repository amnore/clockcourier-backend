package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.RuleInstancePO;
import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.util.PomAnalyseUtil;
import com.edu.nju.clockcourier.vo.*;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MigrationServiceImpl implements MigrationService {

    private static final double CONFIDENCE_THRESHOLD = 0.1;
    private static final double CONFIDENCE_EPSILON = 1e-5;

    private final MigrationDataService dataService;
    private final MvnService mvnService;

    @Autowired
    public MigrationServiceImpl(MigrationDataService dataService, MvnService mvnService) {
        this.dataService = dataService;
        this.mvnService = mvnService;
    }

    @Override
    public List<MigrationGraphVO> relativeMigrationGraph(Integer libId) {
        var nodes = new HashSet<MvnLibVO>();
        var edges = new HashMap<MvnLibVO, List<MigrationEdgeVO>>();

        var transitiveConfidence = new HashMap<Integer, Double>();
        var newNodes = new PriorityQueue<Pair<Integer, Double>>((a, b) -> Double.compare(a.getSecond(), b.getSecond()));
        newNodes.add(Pair.of(libId, 1.0));
        transitiveConfidence.put(libId, 1.0);

        while (!newNodes.isEmpty()) {
            var nodeAndConfidence = newNodes.poll();
            var node = nodeAndConfidence.getFirst();
            var confidence = nodeAndConfidence.getSecond();

            if (confidence < transitiveConfidence.get(node) - CONFIDENCE_EPSILON) {
                continue;
            }
            var libInfo = mvnService.getSpecificMvnLib(node);
            nodes.add(libInfo);

            var outEdges = dataService.allRuleWithSpecificStart(node);
            var nodesFromThis = outEdges.stream()
                    .map(MigrationRulePO::getToId)
                    .collect(Collectors.toSet());

            // add edges
            var edgeConfidence = outEdges.stream()
                    .collect(Collectors.toMap(MigrationRulePO::getToId, MigrationRulePO::getConfidence, (c1, c2) -> c1));
            var inDegree = outEdges.stream()
                    .collect(Collectors.toMap(MigrationRulePO::getToId, p -> 1, Integer::sum));
            var mergedEdges = nodesFromThis.stream()
                    .map(id -> new MigrationEdgeVO(id, edgeConfidence.get(id), inDegree.get(id)))
                    .filter(e -> e.getConfidence() > CONFIDENCE_THRESHOLD)
                    .collect(Collectors.toList());
            edges.put(libInfo, mergedEdges);

            // add nodes
            var newNodesFromThis = mergedEdges.stream()
                    .map(e -> Pair.of(e.getLibId(), confidence * e.getConfidence()))
                    .filter(p -> p.getSecond() > Math.max(CONFIDENCE_THRESHOLD,
                            transitiveConfidence.getOrDefault(p.getFirst(), 0.0) + CONFIDENCE_EPSILON))
                    .collect(Collectors.toList());
            newNodes.addAll(newNodesFromThis);
            transitiveConfidence.putAll(newNodesFromThis.stream()
                    .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond)));
        }

        return nodes.stream()
                .map(n -> new MigrationGraphVO(
                        n,
                        transitiveConfidence.get(n.getLibId()),
                        edges.getOrDefault(n, List.of()).stream()
                                .filter(e -> transitiveConfidence.containsKey(e.getLibId()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    //解析pom文件并返回lib列表
    //最好用个util来做计算吧
    @Override
    public MvnLibListVO analysePom(MvnPomAnalyseDTO dto) throws XmlPullParserException, IOException {

        //先调用工具类解析pom文件，获取依赖的groupId和artifactId
        List<Pair<String, String>> list = PomAnalyseUtil.analyse(dto.getPom());
        MvnLibListVO mvnLibListVO = new MvnLibListVO();
        List<MvnLibVO> mvnLibVOS = new ArrayList<>();

        //然后再对每个依赖查找对应的lib
        for (Pair<String, String> pair : list
        ) {
            mvnLibVOS.add(mvnService.getSpecificMvnLib(pair.getFirst(), pair.getSecond()));
        }
        //返回依赖列表
        mvnLibListVO.setLibs(mvnLibVOS);
        mvnLibListVO.setCount(mvnLibVOS.size());
        return mvnLibListVO;
    }

    //获取迁移实例
    @Override
    public MigInsListVO getInstance(Integer ruleId, Integer page) {

        //先根据ruleId获取迁移规则实例列表
        List<RuleInstancePO> ruleInstancePOS = dataService.getInstance(ruleId, page);
        List<MigrationInstanceVO> migrationInstanceVOS = new ArrayList<>();

        //对每个实例，查找对应的项目信息，组合成具体实例返回
        ruleInstancePOS.forEach(cur -> {
            MvnNewestProjVO mvnNewestProjVO = mvnService.getNewestMvnProj(cur.getProjectId());
            migrationInstanceVOS.add(new MigrationInstanceVO(
                    cur.getRuleId(),
                    mvnNewestProjVO.getName(),
                    cur.getProjectId(),
                    cur.getFileName(),
                    mvnNewestProjVO.getUrl(),
                    cur.getStartCommitLink(),
                    cur.getEndCommitLink()));
        });

        //返回结果
        int count = ruleInstancePOS.size();
        MigInsListVO migInsListVO = new MigInsListVO(count, migrationInstanceVOS);
        return migInsListVO;
    }
}
