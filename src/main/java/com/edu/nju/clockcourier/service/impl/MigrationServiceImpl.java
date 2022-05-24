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
        var rootNode = mvnService.getSpecificMvnLib(libId);
        var edges = migrationRuleDataService.rulesWithSpecificStart(libId).stream()
            .map(MigrationRuleVO::build)
            .collect(Collectors.toList());
        var nodes = edges.stream().map(e -> mvnService.getSpecificMvnLib(e.getToId()))
            .collect(Collectors.toList());

        var res = new ArrayList<MigrationNodeVO>();
        res.add(MigrationNodeVO.build(rootNode, edges));
        nodes.stream()
            .map(n -> MigrationNodeVO.build(n, List.of()))
            .forEach(res::add);

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
