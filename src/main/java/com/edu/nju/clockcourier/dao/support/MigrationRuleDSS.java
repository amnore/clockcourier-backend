package com.edu.nju.clockcourier.dao.support;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MigrationRuleDSS {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final MigrationRule migrationRule = new MigrationRule();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> fromId = migrationRule.fromId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> toId = migrationRule.toId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> projectId = migrationRule.projectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> version = migrationRule.version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Double> confidence = migrationRule.confidence;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class MigrationRule extends SqlTable {
        public final SqlColumn<Integer> fromId = column("from_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> toId = column("to_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> version = column("version", JDBCType.VARCHAR);

        public final SqlColumn<Double> confidence = column("confidence", JDBCType.DOUBLE);

        public MigrationRule() {
            super("migration_rules");
        }
    }
}