package com.edu.nju.clockcourier.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class CalcTaskTest {

    private final CalcTask task;

    @Autowired
    public CalcTaskTest(CalcTask task) {
        this.task = task;
    }

    @Test
    public void testRun() {
        this.task.process();
    }

}
