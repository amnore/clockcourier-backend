package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dao.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectDataServiceImpl(ProjectMapper projectMapper){
        this.projectMapper=projectMapper;
    }


}
