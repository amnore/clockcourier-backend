package com.edu.nju.clockcourier.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectPOMapperTest {

    private final ProjectPOMapper projectPOMapper;

    @Autowired
    public ProjectPOMapperTest(ProjectPOMapper projectPOMapper){
        this.projectPOMapper=projectPOMapper;
    }

    @Test
    void selectByPrimaryKey() {
//        System.out.println(projectPOMapper.selectByPrimaryKey(31613));
    }


}