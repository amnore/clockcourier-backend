package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.MigrationEdgeVO;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MigrationServiceImpl implements MigrationService {

    private static final int maxRecurLevel = 3;

    private final MigrationDataService dataService;
    private final MvnService mvnService;

    @Autowired
    public MigrationServiceImpl(MigrationDataService dataService, MvnService mvnService) {
        this.dataService = dataService;
        this.mvnService = mvnService;
    }

    private Pair<Set<MvnLibVO>, Map<MvnLibVO, List<MigrationEdgeVO>>> getMigrationGraph(Integer libId) {
        var nodes = new HashSet<MvnLibVO>();
        var edges = new HashMap<MvnLibVO, List<MigrationEdgeVO>>();

        var distance = new HashMap<Integer, Integer>();
        var newNodes = new ArrayDeque<Integer>();
        newNodes.add(libId);
        distance.put(libId, 0);

        while (!newNodes.isEmpty()) {
            var node = newNodes.pop();
            var libInfo = mvnService.getSpecificMvnLib(node);
            nodes.add(libInfo);
            if (distance.get(node) >= maxRecurLevel) {
                continue;
            }

            var outEdges = dataService.allRuleWithSpecificStart(node);
            var nodesFromThis = outEdges.stream()
                .map(e -> e.getToId())
                .distinct().collect(Collectors.toList());

            var confidence = outEdges.stream()
                    .collect(Collectors.toMap(e -> e.getToId(), e -> e.getConfidence(), (c1, c2) -> c1));
            var inDegree = new HashMap<Integer, Integer>();
            outEdges.forEach(e -> inDegree.compute(e.getToId(), (id, count) -> count == null ? 1 : count + 1));
            edges.put(libInfo,
                    nodesFromThis.stream()
                      .map(id -> new MigrationEdgeVO(id, confidence.get(id), inDegree.get(id)))
                      .collect(Collectors.toList()));

            var nodeDistance = distance.get(node);
            var newNodesFromThis = nodesFromThis.stream()
                .filter(n -> distance.get(n) == null)
                .collect(Collectors.toList());
            newNodes.addAll(newNodesFromThis);
            distance.putAll(newNodesFromThis.stream()
                            .collect(Collectors.toMap(id -> id, id -> nodeDistance + 1)));
        }

        return Pair.of(nodes, edges);
    }

    @Override
    public List<MigrationGraphVO> relativeMigrationGraph(Integer libId) {
        var nodesAndEdges = getMigrationGraph(libId);
        return nodesAndEdges.getFirst().stream()
                .map(n -> new MigrationGraphVO(n, nodesAndEdges.getSecond().getOrDefault(n, List.of())))
                .collect(Collectors.toList());
    }
}
