package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MigrationControllerTest {

    @Autowired
    private MigrationController migrationController;

    @Test
    void getMvnMigrationGraph() {
        List<MigrationGraphVO> vos = migrationController.getMvnMigrationGraph("3").getData();
        for (MigrationGraphVO vo : vos) {
            assertEquals(3, vo.getFromLibInfo().getLibId());
        }
    }
}