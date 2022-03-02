package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.po.RepositoryPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryDataServiceTest {

    private final RepositoryDataService repositoryDataService;
    private final DatabaseConfig config;

    @Autowired
    public RepositoryDataServiceTest(RepositoryDataService repositoryDataService, DatabaseConfig databaseConfig){
        this.repositoryDataService=repositoryDataService;
        this.config=databaseConfig;
    }

    @Test
    void getRepository() {
        RepositoryPO repositoryPO=repositoryDataService.getRepository(427);
        String ExpectName=repositoryPO.getRepositoryName();
        assertEquals("gentleface-sprites",repositoryPO.getRepositoryName());

    }

    @Test
    void allAndFilter() {
    }

    @Test
    void allDepAndFilter() {
    }
}