package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

@Generated("org.mybatis.generator.api.MyBatisGenerator")
public final class RuleInstanceDSS {

    public static final RuleInstance ruleInstance = new RuleInstance();

    public static final SqlColumn<Integer> ruleId = ruleInstance.ruleId;

    public static final SqlColumn<Integer> projectId = ruleInstance.projectId;

    public static final SqlColumn<String> fileName = ruleInstance.fileName;

    public static final SqlColumn<String> startCommitLink = ruleInstance.startCommitLink;

    public static final SqlColumn<String> endCommitLink = ruleInstance.endCommitLink;

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