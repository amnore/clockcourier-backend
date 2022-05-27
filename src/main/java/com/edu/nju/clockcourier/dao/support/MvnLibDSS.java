package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

@Generated("org.mybatis.generator.api.MyBatisGenerator")
public final class MvnLibDSS {

    public static final MvnLib mvnLib = new MvnLib();

    public static final SqlColumn<Integer> libId = mvnLib.libId;

    public static final SqlColumn<String> groupId = mvnLib.groupId;

    public static final SqlColumn<String> artifactId = mvnLib.artifactId;

    public static final SqlColumn<String> mvnCtrUrl = mvnLib.mvnCtrUrl;

    public static final SqlColumn<String> githubUrl = mvnLib.githubUrl;

    public static final SqlColumn<String> description = mvnLib.description;

    public static final SqlColumn<Integer> startRuleNum = mvnLib.startRuleNum;

    public static final class MvnLib extends SqlTable {
        public final SqlColumn<Integer> libId = column("lib_id", JDBCType.INTEGER);

        public final SqlColumn<String> groupId = column("group_id", JDBCType.VARCHAR);

        public final SqlColumn<String> artifactId = column("artifact_id", JDBCType.VARCHAR);

        public final SqlColumn<String> mvnCtrUrl = column("mvn_ctr_url", JDBCType.VARCHAR);

        public final SqlColumn<String> githubUrl = column("github_url", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> startRuleNum = column("start_rule_num", JDBCType.INTEGER);

        public MvnLib() {
            super("mvn_libs");
        }
    }

}