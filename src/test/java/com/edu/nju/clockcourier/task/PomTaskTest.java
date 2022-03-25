package com.edu.nju.clockcourier.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
public class PomTaskTest {

    private final PomTask pomTask;

    @Autowired
    public PomTaskTest(PomTask task) {
        this.pomTask = task;
    }

    @Test
    public void realRun() {
        String from = "/home/xiayi/Mine/code/workspace/se3/doc/waiting";
        String to = "/home/xiayi/Mine/code/workspace/se3/doc/finished";
        this.pomTask.process(null, to);
    }

    @Test
    public void testRun() {
        String from = "/home/xiayi/Mine/code/workspace/se3/backend-clockcourier/doc/pom-test-waiting";
        String to = "/home/xiayi/Mine/code/workspace/se3/backend-clockcourier/doc/pom-test-finished";
        this.pomTask.process(null, to);
    }

}
