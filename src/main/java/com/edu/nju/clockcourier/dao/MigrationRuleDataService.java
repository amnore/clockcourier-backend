package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MigrationRulePO;

import java.util.List;

public interface MigrationRuleDataService {

    MigrationRulePO getRule(Integer ruleId);

    List<MigrationRulePO> rulesWithSpecificStart(Integer fromId);

}
