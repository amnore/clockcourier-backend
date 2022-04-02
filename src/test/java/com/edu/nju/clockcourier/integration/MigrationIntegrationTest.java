package com.edu.nju.clockcourier.integration;

import com.edu.nju.clockcourier.controller.MigrationController;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MigrationIntegrationTest {

    private final MigrationController migrationController;

    @Autowired
    public MigrationIntegrationTest(MigrationController migrationController) {
        this.migrationController = migrationController;
    }

    // L3-2
    @Test
    public void migrationGraphTest() {
        String libId = "1395";
        List<MigrationGraphVO> list = this.migrationController.getMvnMigrationGraph(libId).getData();
        assertNotNull(list);
        boolean flag = false;
        // 存在这条边
        for (MigrationGraphVO vo : list) {
            MvnLibVO info = vo.getFromLibInfo();
            assertNotNull(info);
            if (flag) continue;
            if (!info.getLibId().equals(Integer.parseInt(libId))) flag = true;
        }
        assertTrue(flag);
    }

}
