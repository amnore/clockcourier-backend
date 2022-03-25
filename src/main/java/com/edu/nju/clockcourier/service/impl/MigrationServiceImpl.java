package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.MigrationEdgeVO;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    private MigrationGraphVO graphHelper(Integer libId, Integer curLevel) {
        MigrationGraphVO res = new MigrationGraphVO();
        // 基本信息
        MvnLibVO lib = this.mvnService.getSpecificMvnLib(libId);
        res.setFromLibInfo(lib);
        if (curLevel > maxRecurLevel) return res;
        // 它的所有边
        List<MigrationEdgeVO> edges = new ArrayList<>();
        List<MigrationRulePO> migrationRuleList = this.dataService
                .allRuleWithSpecificStart(libId);
        int len = migrationRuleList.size();
        if (len == 0) return res;
        int num = 0;
        Integer tarToId = migrationRuleList.get(0).getToId();
        for (int i = 0; i < len; ++i) {
            Integer curToId = migrationRuleList.get(i).getToId();
            if (tarToId.equals(curToId)) {
                ++num;
                if (i != len - 1) continue;
            }
            MigrationEdgeVO edge = new MigrationEdgeVO();
            edge.setNum(num);
            edge.setToLibInfo(this.graphHelper(tarToId, curLevel + 1));
            edges.add(edge);
            if (i == len - 1) break;
            tarToId = curToId;
            num = 1;
        }
        res.setEdges(edges);
        return res;
    }

    @Override
    public MigrationGraphVO relativeMigrationGraph(Integer libId) {
        return this.graphHelper(libId, 0);
    }

}
