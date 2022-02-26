package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.util.Date;

public final class ProjectDSS {

    public static final Projects PROJECTS = new Projects();

    public static final SqlColumn<Integer> projectId = PROJECTS.projectId;

    public static final SqlColumn<String> projectName = PROJECTS.projectName;

    public static final SqlColumn<String> platform = PROJECTS.platform;

    public static final SqlColumn<String> language = PROJECTS.language;

    public static final SqlColumn<String> description = PROJECTS.description;

    public static final SqlColumn<String> homepageUrl = PROJECTS.homepageUrl;

    public static final SqlColumn<Date> createTimestamp = PROJECTS.createTimestamp;

    public static final SqlColumn<Date> updateTimestamp = PROJECTS.updateTimestamp;

    public static final SqlColumn<Date> latestReleasePublishTimestamp = PROJECTS.latestReleasePublishTimestamp;

    public static final SqlColumn<String> latestReleaseNumber = PROJECTS.latestReleaseNumber;

    public static final SqlColumn<Integer> repositoryId = PROJECTS.repositoryId;

    public static final SqlColumn<String> repositoryUrl = PROJECTS.repositoryUrl;

    public static final SqlColumn<String> licenses = PROJECTS.licenses;

    public static final class Projects extends SqlTable {

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

        public Projects() {
            super("projects");
        }
    }

}