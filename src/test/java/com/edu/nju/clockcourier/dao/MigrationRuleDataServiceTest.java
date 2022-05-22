package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MigrationRulePO;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled
public class MigrationRuleDataServiceTest {

    private final MigrationRuleDataService migrationRuleDataService;

    @Autowired
    public MigrationRuleDataServiceTest(MigrationRuleDataService migrationRuleDataService) {
        this.migrationRuleDataService = migrationRuleDataService;
    }

    @Test
    @Ignore
    void getRule() {
        MigrationRulePO migrationRulePO = migrationRuleDataService.getRule(1);
        assertEquals(1, migrationRulePO.getRuleId());
    }

    @Test
    @Ignore
    void rulesWithSpecificStart() {
        List<MigrationRulePO> migrationRulePOList = migrationRuleDataService.rulesWithSpecificStart(1);
        for (MigrationRulePO po : migrationRulePOList) {
            assertEquals(1, po.getFromId());
        }
    }

}