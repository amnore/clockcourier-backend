package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MvnProjDataService;
import com.edu.nju.clockcourier.dao.mapper.MigrationRuleMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnDependencyMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnLibMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MvnProjDataServiceImpl implements MvnProjDataService {
    private final MigrationRuleMapper migrationRuleMapper;

    private final MvnDependencyMapper mvnDependencyMapper;

    private final MvnLibMapper mvnLibMapper;

    private final MvnProjectMapper mvnProjectMapper;

    @Autowired
    public MvnProjDataServiceImpl(MigrationRuleMapper migrationRuleMapper,
                                  MvnDependencyMapper mvnDependencyMapper,
                                  MvnLibMapper mvnLibMapper,
                                  MvnProjectMapper mvnProjectMapper){
        this.migrationRuleMapper=migrationRuleMapper;
        this.mvnDependencyMapper=mvnDependencyMapper;
        this.mvnLibMapper=mvnLibMapper;
        this.mvnProjectMapper=mvnProjectMapper;
    }


}
