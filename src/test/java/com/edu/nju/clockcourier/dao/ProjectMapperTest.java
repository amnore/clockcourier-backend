package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dao.mapper.ProjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectMapperTest {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectMapperTest(ProjectMapper projectMapper){
        this.projectMapper = projectMapper;
    }

    @Test
    void selectByPrimaryKey() {
//        System.out.println(projectMapper.selectByPrimaryKey(31613));
    }


}