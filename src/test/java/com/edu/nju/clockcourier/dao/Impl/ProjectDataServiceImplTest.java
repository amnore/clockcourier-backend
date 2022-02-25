package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.ProjectDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectDataServiceImplTest {
    private final ProjectDataService projectDataService;

    @Autowired
    public ProjectDataServiceImplTest(ProjectDataService projectDataService){
        this.projectDataService=projectDataService;
    }

    @Test
    void test1(){
//        System.out.println(projectDataService.getProject(31613));
    }


}