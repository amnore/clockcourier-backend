package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class MvnDepDSS {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final MvnDependency mvnDependency = new MvnDependency();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> projectId = mvnDependency.projectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> version = mvnDependency.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> libId = mvnDependency.libId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> libVersion = mvnDependency.libVersion;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class MvnDependency extends SqlTable {
        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> version = column("version", JDBCType.VARCHAR);

        public final SqlColumn<Integer> libId = column("lib_id", JDBCType.INTEGER);

        public final SqlColumn<String> libVersion = column("lib_version", JDBCType.VARCHAR);

        public MvnDependency() {
            super("mvn_dependencies");
        }
    }
}