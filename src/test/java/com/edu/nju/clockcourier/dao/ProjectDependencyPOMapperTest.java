package com.edu.nju.clockcourier.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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