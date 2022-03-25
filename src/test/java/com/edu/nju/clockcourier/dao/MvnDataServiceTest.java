package com.edu.nju.clockcourier.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MvnDataServiceTest {

    private final MvnDataService dataService;

    @Autowired
    public MvnDataServiceTest(MvnDataService dataService) {
        this.dataService = dataService;
    }

    @Test
    public void getMvnProjIdTest() {
    }

}
