package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.dao.mapper.MigrationRuleMapper;
import com.edu.nju.clockcourier.dao.support.MigrationRuleDSS;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class MigrationDataServiceImpl implements MigrationDataService {

    private final MigrationRuleMapper migrationRuleMapper;

    @Autowired
    public MigrationDataServiceImpl(MigrationRuleMapper migrationDataService) {
        this.migrationRuleMapper = migrationDataService;
    }


    @Override
    public void insertRuleIfNotExists(MigrationRulePO po) {
        long c = this.migrationRuleMapper.count(cur -> cur
                .where(MigrationRuleDSS.fromId, isEqualTo(po.getFromId()))
                .and(MigrationRuleDSS.toId, isEqualTo(po.getToId()))
                .and(MigrationRuleDSS.projectId, isEqualTo(po.getProjectId()))
                .and(MigrationRuleDSS.version, isEqualTo(po.getVersion())));
        if (c != 0L) return;
        this.migrationRuleMapper.insert(po);
    }
}
