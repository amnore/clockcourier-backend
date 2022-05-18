package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.vo.MigrationInstanceListVO;
import com.edu.nju.clockcourier.vo.MigrationNodeVO;

import java.util.List;

public interface MigrationService {

    List<MigrationNodeVO> getMigrationGraph(Integer libId);

    MigrationInstanceListVO getInstance(Integer ruleId, Integer page);
    
}
