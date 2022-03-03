package com.edu.nju.clockcourier.constant;

import com.edu.nju.clockcourier.dao.support.RepositoryDSS;
import lombok.Getter;
import org.mybatis.dynamic.sql.SqlColumn;

@Getter
public enum RepoSortRule {

    Name(RepositoryDSS.repositoryName),
    CreateT(RepositoryDSS.createTimestamp),
    UpdateT(RepositoryDSS.updateTimestamp),
    LatestPushT(RepositoryDSS.latestPushTimestamp),
    WatcherCount(RepositoryDSS.watcherCount),
    StarCount(RepositoryDSS.starCount),
    ForkCount(RepositoryDSS.forkCount),
    ContributorCount(RepositoryDSS.contributorCount),
    OpenIssueCount(RepositoryDSS.openIssueCount);

    private final SqlColumn<?> sortRule;

    private final String name;

    RepoSortRule(SqlColumn<?> sortRule) {
        this.sortRule = sortRule;
        this.name = sortRule.name();
    }

}
