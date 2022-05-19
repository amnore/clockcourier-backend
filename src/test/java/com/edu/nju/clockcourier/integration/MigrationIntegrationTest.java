package com.edu.nju.clockcourier.integration;

import com.edu.nju.clockcourier.controller.MigrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MigrationIntegrationTest {

    private final MigrationController migrationController;

    @Autowired
    public MigrationIntegrationTest(MigrationController migrationController) {
        this.migrationController = migrationController;
    }

}
