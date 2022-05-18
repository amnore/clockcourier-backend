package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.dao.mapper.MigrationRuleMapper;
import com.edu.nju.clockcourier.dao.mapper.RuleInstanceMapper;
import com.edu.nju.clockcourier.dao.support.MigrationRuleDSS;
import com.edu.nju.clockcourier.dao.support.RuleInstanceDSS;
import com.edu.nju.clockcourier.po.RuleInstancePO;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class MigrationDataServiceImpl implements MigrationDataService {

    private final MigrationRuleMapper migrationRuleMapper;

    private final RuleInstanceMapper ruleInstanceMapper;

    @Autowired
    public MigrationDataServiceImpl(MigrationRuleMapper migrationDataService, RuleInstanceMapper ruleInstanceMapper) {
        this.migrationRuleMapper = migrationDataService;
        this.ruleInstanceMapper = ruleInstanceMapper;
    }

    // todo: 获取某一页的数据需要对代码再进行修改
    @Override
    public List<RuleInstancePO> getInstance(Integer ruleId, Integer page) {
        SelectStatementProvider select = SqlBuilder
                .select(RuleInstanceMapper.selectList)
                .from(RuleInstanceDSS.ruleInstance)
                .where(MigrationRuleDSS.ruleId, isEqualTo(ruleId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.ruleInstanceMapper.selectMany(select);
    }

}
