package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dao.mapper.ProjectMapper;
import com.edu.nju.clockcourier.po.ProjectPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectDataServiceImpl(ProjectMapper projectMapper){
        this.projectMapper=projectMapper;
    }


    @Override
    public ProjectPO getProject(Integer id) {
        Optional<ProjectPO> projectOptional=projectMapper.selectByPrimaryKey(id);
        return projectOptional.orElse(null);
    }
}
