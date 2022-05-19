package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.vo.MigrationInstanceListVO;
import com.edu.nju.clockcourier.vo.MigrationNodeVO;
import com.edu.nju.clockcourier.vo.MigrationRuleVO;

import java.util.List;

public interface MigrationService {

    List<MigrationNodeVO> getMigrationGraph(Integer libId);

    MigrationRuleVO getRule(Integer ruleId);

    MigrationInstanceListVO getInstance(Integer ruleId, Integer page);

}
