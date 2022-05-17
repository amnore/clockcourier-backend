package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.RuleInstancePO;

import java.util.List;

public interface MigrationDataService {

    void insertRuleIfNotExists(MigrationRulePO po);

    List<MigrationRulePO> allRuleWithSpecificStart(Integer start);

    List<RuleInstancePO> getInstance(Integer ruleId, Integer page);

}
