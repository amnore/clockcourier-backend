package com.edu.nju.clockcourier.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositoryServiceTest {

    private final RepositoryService repositoryService;

    @Autowired
    public RepositoryServiceTest(RepositoryService repositoryService){
        this.repositoryService=repositoryService;
    }

    @Test
    void getRepositoryTest(){

    }

    @Test
    void getRepositoriesTest(){

    }

    @Test
    void getDependenciesTest(){}

}
