package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.RuleInstancePO;

import java.util.List;

public interface MigrationDataService {

    List<RuleInstancePO> getInstance(Integer ruleId, Integer page);

}
