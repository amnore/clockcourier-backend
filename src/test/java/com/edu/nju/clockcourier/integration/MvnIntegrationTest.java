package com.edu.nju.clockcourier.integration;

import com.edu.nju.clockcourier.controller.MvnLibraryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MvnIntegrationTest {

    private final MvnLibraryController mvnLibraryController;

    @Autowired
    public MvnIntegrationTest(MvnLibraryController mvnLibraryController) {
        this.mvnLibraryController = mvnLibraryController;
    }

}
