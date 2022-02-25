package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.mapper.ProjectDependencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDependencyDataServiceImpl {

    private final ProjectDependencyMapper projectDependencyMapper;

    @Autowired
    public ProjectDependencyDataServiceImpl(ProjectDependencyMapper projectDependencyMapper){
        this.projectDependencyMapper=projectDependencyMapper;
    }
}
