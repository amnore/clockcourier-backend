package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MvnProjectPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MvnProjectDataServiceTest {

    private final MvnProjectDataService mvnProjectDataService;

    @Autowired
    public MvnProjectDataServiceTest(MvnProjectDataService mvnProjectDataService) {
        this.mvnProjectDataService = mvnProjectDataService;
    }

    @Test
    public void getProjectTest() {
        MvnProjectPO mvnProjectPO = mvnProjectDataService.getProject(1);
        assertEquals(1, mvnProjectPO.getProjectId());
    }

}