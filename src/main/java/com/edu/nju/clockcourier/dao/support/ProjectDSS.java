package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.util.Date;

public final class ProjectDSS {

    public static final ProjectPO projectPO = new ProjectPO();

    public static final SqlColumn<Integer> projectId = projectPO.projectId;

    public static final SqlColumn<String> projectName = projectPO.projectName;

    public static final SqlColumn<String> platform = projectPO.platform;

    public static final SqlColumn<String> language = projectPO.language;

    public static final SqlColumn<String> description = projectPO.description;

    public static final SqlColumn<String> homepageUrl = projectPO.homepageUrl;

    public static final SqlColumn<Date> createTimestamp = projectPO.createTimestamp;

    public static final SqlColumn<Date> updateTimestamp = projectPO.updateTimestamp;

    public static final SqlColumn<Date> latestReleasePublishTimestamp = projectPO.latestReleasePublishTimestamp;

    public static final SqlColumn<String> latestReleaseNumber = projectPO.latestReleaseNumber;

    public static final SqlColumn<Integer> repositoryId = projectPO.repositoryId;

    public static final SqlColumn<String> repositoryUrl = projectPO.repositoryUrl;

    public static final SqlColumn<String> licenses = projectPO.licenses;

    public static final class ProjectPO extends SqlTable {
        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> projectName = column("project_name", JDBCType.VARCHAR);

        public final SqlColumn<String> platform = column("platform", JDBCType.VARCHAR);

        public final SqlColumn<String> language = column("language", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<String> homepageUrl = column("homepage_url", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTimestamp = column("create_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTimestamp = column("update_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> latestReleasePublishTimestamp = column("latest_release_publish_timestamp", JDBCType.TIMESTAMP);

        public final SqlColumn<String> latestReleaseNumber = column("latest_release_number", JDBCType.VARCHAR);

        public final SqlColumn<Integer> repositoryId = column("repository_id", JDBCType.INTEGER);

        public final SqlColumn<String> repositoryUrl = column("repository_url", JDBCType.VARCHAR);

        public final SqlColumn<String> licenses = column("licenses", JDBCType.VARCHAR);

        public ProjectPO() {
            super("projects");
        }
    }

}