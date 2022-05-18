package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;

@Generated("org.mybatis.generator.api.MyBatisGenerator")
public final class MigrationRuleDSS {

    public static final MigrationRule migrationRule = new MigrationRule();

    public static final SqlColumn<Integer> ruleId = migrationRule.ruleId;

    public static final SqlColumn<Integer> fromId = migrationRule.fromId;

    public static final SqlColumn<Integer> toId = migrationRule.toId;

    public static final SqlColumn<Double> confidence = migrationRule.confidence;

    public static final SqlColumn<Double> ruleSup = migrationRule.ruleSup;

    public static final SqlColumn<Double> msgSup = migrationRule.msgSup;

    public static final SqlColumn<Double> disSup = migrationRule.disSup;

    public static final SqlColumn<Double> apiSup = migrationRule.apiSup;

    public static final class MigrationRule extends SqlTable {
        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> fromId = column("from_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> toId = column("to_id", JDBCType.INTEGER);

        public final SqlColumn<Double> confidence = column("confidence", JDBCType.DOUBLE);

        public final SqlColumn<Double> ruleSup = column("rule_sup", JDBCType.DOUBLE);

        public final SqlColumn<Double> msgSup = column("msg_sup", JDBCType.DOUBLE);

        public final SqlColumn<Double> disSup = column("dis_sup", JDBCType.DOUBLE);

        public final SqlColumn<Double> apiSup = column("api_sup", JDBCType.DOUBLE);

        public MigrationRule() {
            super("migration_rules");
        }
    }

}