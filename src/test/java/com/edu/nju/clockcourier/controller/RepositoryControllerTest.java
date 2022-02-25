package com.edu.nju.clockcourier.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryControllerTest {

    @Resource
    RepositoryController repositoryController;

    @Test
    void test1(){
//        System.out.println(repositoryController.get("427"));
    }


}