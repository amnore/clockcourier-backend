package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MvnProjectPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MvnDataServiceTest {

    private final MvnDataService dataService;

    @Autowired
    public MvnDataServiceTest(MvnDataService dataService) {
        this.dataService = dataService;
    }

    @Test
    public void getMvnProjIdTest() {
        List<MvnProjectPO> all = this.dataService.allMvnProjWithMultiVersions();
        System.out.println(1);
    }

}
