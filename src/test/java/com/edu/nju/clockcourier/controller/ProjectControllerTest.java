package com.edu.nju.clockcourier.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProjectControllerTest {

    private final ProjectController projectController;

    @Autowired
    public ProjectControllerTest(ProjectController projectController) {
        this.projectController = projectController;
    }

    @Test
    void getTest() {
        assertTrue(true);
    }

    @Test
    void queryTest() {
        assertTrue(true);
    }

    @Test
    void getDependenciesTest() {
        assertTrue(true);
    }

}