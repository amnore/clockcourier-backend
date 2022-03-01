package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.ProjectDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SqlColumn;

@Getter
public enum ProjSortRule {

    Name(ProjectDSS.projectName),
    CreateT(ProjectDSS.createTimestamp),
    UpdateT(ProjectDSS.updateTimestamp),
    LatestReleaseT(ProjectDSS.latestReleasePublishTimestamp),
    LatestReleaseN(ProjectDSS.latestReleaseNumber);

    private final SqlColumn<?> sortRule;

    private final String name;

    ProjSortRule(SqlColumn<?> sortRule) {
        this.sortRule = sortRule;
        this.name = sortRule.name();
    }

}
