package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

@Generated("org.mybatis.generator.api.MyBatisGenerator")
public final class MvnProjectDSS {

    public static final MvnProject mvnProject = new MvnProject();

    public static final SqlColumn<Integer> projectId = mvnProject.projectId;

    public static final SqlColumn<String> name = mvnProject.name;

    public static final SqlColumn<String> url = mvnProject.url;

    public static final class MvnProject extends SqlTable {
        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public MvnProject() {
            super("mvn_projects");
        }
    }

}