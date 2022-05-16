package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class MvnLibDSS {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final MvnLib mvnLib = new MvnLib();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> libId = mvnLib.libId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> groupId = mvnLib.groupId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> artifactId = mvnLib.artifactId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> mvnCtrUrl = mvnLib.mvnCtrUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> githubUrl = mvnLib.githubUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class MvnLib extends SqlTable {
        public final SqlColumn<Integer> libId = column("lib_id", JDBCType.INTEGER);

        public final SqlColumn<String> groupId = column("group_id", JDBCType.VARCHAR);

        public final SqlColumn<String> artifactId = column("artifact_id", JDBCType.VARCHAR);

        public final SqlColumn<String> mvnCtrUrl = column("mvn_ctr_url", JDBCType.VARCHAR);

        public final SqlColumn<String> githubUrl = column("github_url", JDBCType.VARCHAR);

        public MvnLib() {
            super("mvn_libs");
        }
    }
}