package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MigrationRulePO;

public interface MigrationDataService {

    void insertRuleIfNotExists(MigrationRulePO po);

}
