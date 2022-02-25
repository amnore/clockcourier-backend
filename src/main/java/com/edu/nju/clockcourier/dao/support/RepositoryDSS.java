package com.edu.nju.clockcourier.dao.support;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RepositoryDSS {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RepositoryPO repositoryPO = new RepositoryPO();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> repositoryId = repositoryPO.repositoryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hostType = repositoryPO.hostType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> repositoryName = repositoryPO.repositoryName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> repositoryOwner = repositoryPO.repositoryOwner;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> language = repositoryPO.language;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> description = repositoryPO.description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> homepageUrl = repositoryPO.homepageUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTimestamp = repositoryPO.createTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTimestamp = repositoryPO.updateTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> latestPushTimestamp = repositoryPO.latestPushTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> fork = repositoryPO.fork;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> forkCount = repositoryPO.forkCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> watcherCount = repositoryPO.watcherCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> starCount = repositoryPO.starCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> contributorCount = repositoryPO.contributorCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> openIssueCount = repositoryPO.openIssueCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> defaultBranch = repositoryPO.defaultBranch;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> licenses = repositoryPO.licenses;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RepositoryPO extends SqlTable {
        public final SqlColumn<Integer> repositoryId = column("repository_id", JDBCType.INTEGER);

        public final SqlColumn<String> hostType = column("host_type", JDBCType.VARCHAR);

        public final SqlColumn<String> repositoryName = column("repository_name", JDBCType.VARCHAR);

        public final SqlColumn<String> repositoryOwner = column("repository_owner", JDBCType.VARCHAR);

        public final SqlColumn<String> language = column("language", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<String> homepageUrl = column("homepage_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTimestamp = column("create_timestamp", JDBCType.DATE);

        public final SqlColumn<Date> updateTimestamp = column("update_timestamp", JDBCType.DATE);

        public final SqlColumn<Date> latestPushTimestamp = column("latest_push_timestamp", JDBCType.DATE);

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