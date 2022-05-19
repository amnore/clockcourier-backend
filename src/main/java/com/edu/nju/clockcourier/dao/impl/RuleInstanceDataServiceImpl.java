package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.RuleInstanceDataService;
import com.edu.nju.clockcourier.dao.mapper.RuleInstanceMapper;
import com.edu.nju.clockcourier.dao.support.MigrationRuleDSS;
import com.edu.nju.clockcourier.dao.support.RuleInstanceDSS;
import com.edu.nju.clockcourier.po.RuleInstancePO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class RuleInstanceDataServiceImpl implements RuleInstanceDataService {

    private final RuleInstanceMapper ruleInstanceMapper;

    @Autowired
    public RuleInstanceDataServiceImpl(RuleInstanceMapper ruleInstanceMapper) {
        this.ruleInstanceMapper = ruleInstanceMapper;
    }

    @Override
    public Pair<List<RuleInstancePO>, Integer> getRelativeInstance(Integer ruleId, Integer pageNum, Integer pageSize) {
        SelectStatementProvider select = SqlBuilder
                .select(RuleInstanceMapper.selectList)
                .from(RuleInstanceDSS.ruleInstance)
                .where(MigrationRuleDSS.ruleId, isEqualTo(ruleId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        PageHelper.startPage(pageNum, pageSize);
        List<RuleInstancePO> res = this.ruleInstanceMapper.selectMany(select);
        PageInfo<RuleInstancePO> info = new PageInfo<>(res, pageSize);
        return Pair.of(res, info.getPages());
    }

}
