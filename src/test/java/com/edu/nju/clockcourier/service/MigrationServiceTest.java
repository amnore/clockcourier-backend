package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.service.impl.MigrationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MigrationServiceTest {

    @Mock
    MigrationDataService migrationDataService;

    @InjectMocks
    MigrationServiceImpl migrationService;

    @Test
    void getMvnProjectsTest() {

    }

    @Test
    void getMvnLibsTest() {

    }

    @Test
    void getSpecificMvnProjTest() {

    }

    @Test
    void getNewestMvnProjTest() {

    }

    @Test
    void getSpecificMvnLibTest() {
        
    }

}