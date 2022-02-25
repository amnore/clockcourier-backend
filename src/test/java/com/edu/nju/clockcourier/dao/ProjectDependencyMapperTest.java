package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dao.mapper.ProjectDependencyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectDependencyMapperTest {

    private final ProjectDependencyMapper projectDependencyMapper;

    @Autowired
    public ProjectDependencyMapperTest(ProjectDependencyMapper projectDependencyMapper){
        this.projectDependencyMapper = projectDependencyMapper;
    }

    @Test
    void selectByPrimaryKey() {
//        System.out.println(projectDependencyPOMapper.selectByPrimaryKey(4266479));
    }
}