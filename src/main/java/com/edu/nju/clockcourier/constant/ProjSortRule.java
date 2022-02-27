package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.ProjectDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SortSpecification;

@Getter
public enum ProjSortRule {

    Name(ProjectDSS.projectName),
    CreateT(ProjectDSS.createTimestamp),
    UpdateT(ProjectDSS.updateTimestamp),
    LatestReleaseT(ProjectDSS.latestReleasePublishTimestamp),
    LatestReleaseN(ProjectDSS.latestReleaseNumber);

    private final SortSpecification sortRule;

    ProjSortRule(SortSpecification sortRule) {
        this.sortRule = sortRule;
    }

}
