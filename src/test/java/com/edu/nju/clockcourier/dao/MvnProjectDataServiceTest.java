package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MvnProjectPO;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled
class MvnProjectDataServiceTest {

    private final MvnProjectDataService mvnProjectDataService;

    @Autowired
    public MvnProjectDataServiceTest(MvnProjectDataService mvnProjectDataService) {
        this.mvnProjectDataService = mvnProjectDataService;
    }

    @Test
    @Ignore
    void getProject() {
        MvnProjectPO mvnProjectPO = mvnProjectDataService.getProject(1);
        assertEquals(mvnProjectPO.getName(), ' ');
    }
}