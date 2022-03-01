package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.RepositoryDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SortSpecification;

@Getter
public enum RepoSortRule {

    Name(RepositoryDSS.repositoryName),
    CreateT(RepositoryDSS.createTimestamp),
    UpdateT(RepositoryDSS.updateTimestamp),
    LatestPushT(RepositoryDSS.latestPushTimestamp),
    WatcherCount(RepositoryDSS.watcherCount),
    StarCount(RepositoryDSS.starCount),
    ContributorCount(RepositoryDSS.contributorCount),
    OpenIssueCount(RepositoryDSS.openIssueCount);

    private final SortSpecification sortRule;

    RepoSortRule(SortSpecification sortRule) {
        this.sortRule = sortRule;
    }

}
