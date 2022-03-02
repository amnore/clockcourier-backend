package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.util.DateParser;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjectControllerTest {

    private final ProjectController projectController;

    @Autowired
    public ProjectControllerTest(ProjectController projectController) {
        this.projectController = projectController;
    }

    @Test
    void getTest() throws ParseException {
        ProjectVO vo = projectController.get(Integer.toString(31613)).getData();
        Date actual = vo.getCreateT();
        Date expected = DateParser.parse("2015-01-21 12:25:46");
        assertEquals(actual.getTime(), expected.getTime());
    }

    @Test
    void queryTest(){
    }

    @Test
    void getDependenciesTest(){

    }

}