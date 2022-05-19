package com.edu.nju.clockcourier.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MvnLibraryDataServiceTest {

    @Autowired
    public MvnLibraryDataService mvnDataService;

    @Test
    public void test() {
        this.mvnDataService.getMvnLib(1);
    }

}