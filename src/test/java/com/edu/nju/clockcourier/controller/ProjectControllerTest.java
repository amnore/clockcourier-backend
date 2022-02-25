package com.edu.nju.clockcourier.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectControllerTest {

    private final ProjectController projectController;

    @Autowired
    public ProjectControllerTest(ProjectController projectController){
        this.projectController=projectController;
    }

    @Test
    void test1(){
        System.out.println(projectController.get(Integer.toString(31613)));
    }
}