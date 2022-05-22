package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.RuleInstancePO;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled
public class RuleInstanceDataServiceTest {

    private final RuleInstanceDataService ruleInstanceDataService;

    @Autowired
    public RuleInstanceDataServiceTest(RuleInstanceDataService ruleInstanceDataService) {
        this.ruleInstanceDataService = ruleInstanceDataService;
    }

    @Test
    @Ignore
    public void getRelativeInstance() {
        var res = this.ruleInstanceDataService.getRelativeInstance(1, 2, 2);
        for (RuleInstancePO ruleInstance : res.getFirst()) {
            assertEquals(1, ruleInstance.getRuleId());
        }
    }

}
