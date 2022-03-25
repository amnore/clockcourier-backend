package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class MvnProjDSS {

    public static final MvnProject mvnProject = new MvnProject();


    public static final SqlColumn<Integer> projectId = mvnProject.projectId;


    public static final SqlColumn<String> version = mvnProject.version;


    public static final SqlColumn<String> groupId = mvnProject.groupId;


    public static final SqlColumn<String> artifactId = mvnProject.artifactId;


    public static final SqlColumn<String> name = mvnProject.name;


    public static final SqlColumn<String> url = mvnProject.url;


    public static final SqlColumn<String> description = mvnProject.description;


    public static final class MvnProject extends SqlTable {
        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> version = column("version", JDBCType.VARCHAR);

        public final SqlColumn<String> groupId = column("group_id", JDBCType.VARCHAR);

        public final SqlColumn<String> artifactId = column("artifact_id", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public MvnProject() {
            super("mvn_projects");
        }
    }
}