package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

public final class RuleInstanceDSS {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RuleInstance ruleInstance = new RuleInstance();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> ruleId = ruleInstance.ruleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> projectId = ruleInstance.projectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> fileName = ruleInstance.fileName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> startCommitLink = ruleInstance.startCommitLink;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> endCommitLink = ruleInstance.endCommitLink;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RuleInstance extends SqlTable {
        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> fileName = column("file_name", JDBCType.VARCHAR);

        public final SqlColumn<String> startCommitLink = column("start_commit_link", JDBCType.VARCHAR);

        public final SqlColumn<String> endCommitLink = column("end_commit_link", JDBCType.VARCHAR);

        public RuleInstance() {
            super("rule_instances");
        }
    }
}