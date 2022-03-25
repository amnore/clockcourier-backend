package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MigrationRulePO;

import java.util.List;

public interface MigrationDataService {

    void insertRuleIfNotExists(MigrationRulePO po);

    List<MigrationRulePO> allRuleWithSpecificStart(Integer start);

}
