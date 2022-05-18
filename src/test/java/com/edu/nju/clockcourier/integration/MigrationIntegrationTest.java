package com.edu.nju.clockcourier.integration;

import com.edu.nju.clockcourier.controller.MvnMigrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MigrationIntegrationTest {

    private final MvnMigrationController mvnMigrationController;

    @Autowired
    public MigrationIntegrationTest(MvnMigrationController mvnMigrationController) {
        this.mvnMigrationController = mvnMigrationController;
    }

}
