package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dao.mapper.ProjectDependencyPOMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectDependencyPOMapperTest {

    private final ProjectDependencyPOMapper projectDependencyPOMapper;

    @Autowired
    public ProjectDependencyPOMapperTest(ProjectDependencyPOMapper projectDependencyPOMapper){
        this.projectDependencyPOMapper=projectDependencyPOMapper;
    }

    @Test
    void selectByPrimaryKey() {
//        System.out.println(projectDependencyPOMapper.selectByPrimaryKey(4266479));
    }
}