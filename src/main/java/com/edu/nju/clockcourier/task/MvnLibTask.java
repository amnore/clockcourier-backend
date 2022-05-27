package com.edu.nju.clockcourier.task;

import com.edu.nju.clockcourier.dao.MigrationRuleDataService;
import com.edu.nju.clockcourier.dao.MvnLibraryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MvnLibTask {

    private final MvnLibraryDataService mvnLibraryDataService;
    private final MigrationRuleDataService migrationRuleDataService;

    @Autowired
    public MvnLibTask(MvnLibraryDataService mvnLibraryDataService,
                      MigrationRuleDataService migrationRuleDataService) {
        this.mvnLibraryDataService = mvnLibraryDataService;
        this.migrationRuleDataService = migrationRuleDataService;
    }

    public void calculateMvnLibStartRuleNum() {
        List<Integer> allLibId = this.mvnLibraryDataService.allMvnLibId();
        // Pair<以这个仓库为起点的迁移规则数量, 仓库 id>
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        // 计算
        for (Integer curId : allLibId) {
            Integer count = this.migrationRuleDataService.ruleCountWithSpecificStart(curId);
            System.err.printf("Cur id: %d, count: %d\n", curId, count);
            list.add(Pair.of(count, curId));
        }
        // 更新
        list.forEach(c -> this.mvnLibraryDataService.updateStartRuleNum(c.getSecond(), c.getFirst()));
    }

}
