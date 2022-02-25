package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.util.Date;

public final class RepositoryDSS {

    public static final RepositoryPO repositoryPO = new RepositoryPO();

    public static final SqlColumn<Integer> repositoryId = repositoryPO.repositoryId;

    public static final SqlColumn<String> hostType = repositoryPO.hostType;

    public static final SqlColumn<String> repositoryName = repositoryPO.repositoryName;

    public static final SqlColumn<String> repositoryOwner = repositoryPO.repositoryOwner;

    public static final SqlColumn<String> language = repositoryPO.language;

    public static final SqlColumn<String> description = repositoryPO.description;

    public static final SqlColumn<String> homepageUrl = repositoryPO.homepageUrl;

    public static final SqlColumn<Date> createTimestamp = repositoryPO.createTimestamp;

    public static final SqlColumn<Date> updateTimestamp = repositoryPO.updateTimestamp;

    public static final SqlColumn<Date> latestPushTimestamp = repositoryPO.latestPushTimestamp;

    public static final SqlColumn<Integer> fork = repositoryPO.fork;

    public static final SqlColumn<Integer> forkCount = repositoryPO.forkCount;

    public static final SqlColumn<Integer> watcherCount = repositoryPO.watcherCount;

    public static final SqlColumn<Integer> starCount = repositoryPO.starCount;

    public static final SqlColumn<Integer> contributorCount = repositoryPO.contributorCount;

    public static final SqlColumn<Integer> openIssueCount = repositoryPO.openIssueCount;

    public static final SqlColumn<String> defaultBranch = repositoryPO.defaultBranch;

    public static final SqlColumn<String> licenses = repositoryPO.licenses;

    public static final class RepositoryPO extends SqlTable {
        public final SqlColumn<Integer> repositoryId = column("repository_id", JDBCType.INTEGER);

        public final SqlColumn<String> hostType = column("host_type", JDBCType.VARCHAR);

        public final SqlColumn<String> repositoryName = column("repository_name", JDBCType.VARCHAR);

        public final SqlColumn<String> repositoryOwner = column("repository_owner", JDBCType.VARCHAR);

        public final SqlColumn<String> language = column("language", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<String> homepageUrl = column("homepage_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTimestamp = column("create_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTimestamp = column("update_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> latestPushTimestamp = column("latest_push_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> fork = column("fork", JDBCType.INTEGER);

        public final SqlColumn<Integer> forkCount = column("fork_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> watcherCount = column("watcher_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> starCount = column("star_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> contributorCount = column("contributor_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> openIssueCount = column("open_issue_count", JDBCType.INTEGER);

        public final SqlColumn<String> defaultBranch = column("default_branch", JDBCType.VARCHAR);

        public final SqlColumn<String> licenses = column("licenses", JDBCType.VARCHAR);

        public RepositoryPO() {
            super("repositories");
        }
    }
    
}