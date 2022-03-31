package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MigrationRulePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MigrationDataServiceTest {

    @Autowired
    private MigrationDataService migrationDataService;
    

    @Test
    void allRuleWithSpecificStart() {
        List<MigrationRulePO> migrationRulePOList = migrationDataService.allRuleWithSpecificStart(3);
        for (MigrationRulePO po : migrationRulePOList) {
            assertEquals(3, po.getFromId());
        }
    }
}