package com.edu.nju.clockcourier.dao.support;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ProjectDSS {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ProjectPO projectPO = new ProjectPO();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> projectId = projectPO.projectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> projectName = projectPO.projectName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> platform = projectPO.platform;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> language = projectPO.language;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> description = projectPO.description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> homepageUrl = projectPO.homepageUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTimestamp = projectPO.createTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTimestamp = projectPO.updateTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> latestReleasePublishTimestamp = projectPO.latestReleasePublishTimestamp;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> latestReleaseNumber = projectPO.latestReleaseNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> repositoryId = projectPO.repositoryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> repositoryUrl = projectPO.repositoryUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> licenses = projectPO.licenses;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ProjectPO extends SqlTable {
        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> projectName = column("project_name", JDBCType.VARCHAR);

        public final SqlColumn<String> platform = column("platform", JDBCType.VARCHAR);

        public final SqlColumn<String> language = column("language", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<String> homepageUrl = column("homepage_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTimestamp = column("create_timestamp", JDBCType.DATE);

        public final SqlColumn<Date> updateTimestamp = column("update_timestamp", JDBCType.DATE);

        public final SqlColumn<Date> latestReleasePublishTimestamp = column("latest_release_publish_timestamp", JDBCType.DATE);

        public final SqlColumn<String> latestReleaseNumber = column("latest_release_number", JDBCType.VARCHAR);

        public final SqlColumn<Integer> repositoryId = column("repository_id", JDBCType.INTEGER);

        public final SqlColumn<String> repositoryUrl = column("repository_url", JDBCType.VARCHAR);

        public final SqlColumn<String> licenses = column("licenses", JDBCType.VARCHAR);

        public ProjectPO() {
            super("projects");
        }
    }
}