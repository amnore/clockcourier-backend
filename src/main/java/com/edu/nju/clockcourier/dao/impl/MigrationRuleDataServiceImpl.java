package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MigrationRuleDataService;
import com.edu.nju.clockcourier.dao.mapper.MigrationRuleMapper;
import com.edu.nju.clockcourier.dao.support.MigrationRuleDSS;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class MigrationRuleDataServiceImpl implements MigrationRuleDataService {

    private final MigrationRuleMapper migrationRuleMapper;

    @Autowired
    public MigrationRuleDataServiceImpl(MigrationRuleMapper migrationDataService) {
        this.migrationRuleMapper = migrationDataService;
    }

    @Override
    public MigrationRulePO getRule(Integer ruleId) {
        return this.migrationRuleMapper.selectByPrimaryKey(ruleId)
                .orElse(MigrationRulePO.getNullInstance());
    }

    @Override
    public List<MigrationRulePO> rulesWithSpecificStart(Integer fromId) {
        SelectStatementProvider selector = SqlBuilder
                .select(MigrationRuleMapper.selectList)
                .from(MigrationRuleDSS.migrationRule)
                .where(MigrationRuleDSS.fromId, isEqualTo(fromId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.migrationRuleMapper.selectMany(selector);
    }

}
