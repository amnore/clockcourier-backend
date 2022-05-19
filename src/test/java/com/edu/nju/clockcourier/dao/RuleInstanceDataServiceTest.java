package com.edu.nju.clockcourier.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RuleInstanceDataServiceTest {

    private final RuleInstanceDataService ruleInstanceDataService;

    @Autowired
    public RuleInstanceDataServiceTest(RuleInstanceDataService ruleInstanceDataService) {
        this.ruleInstanceDataService = ruleInstanceDataService;
    }

    @Test
    public void relativeInstanceTest() {
        var res = this.ruleInstanceDataService.getRelativeInstance(1, 2, 2);
        System.out.println(res.getSecond());
        res.getFirst().forEach(System.out::println);
    }

}
