package com.edu.nju.clockcourier.dao.support;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ProjectDependencyPODynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ProjectDependencyPO projectDependencyPO = new ProjectDependencyPO();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dependencyId = projectDependencyPO.dependencyId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> projectId = projectDependencyPO.projectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> projectName = projectDependencyPO.projectName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> platform = projectDependencyPO.platform;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> projectVersion = projectDependencyPO.projectVersion;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> dependencyProjectId = projectDependencyPO.dependencyProjectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> dependencyProjectName = projectDependencyPO.dependencyProjectName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> dependencyProjectPlatform = projectDependencyPO.dependencyProjectPlatform;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> dependencyRequirements = projectDependencyPO.dependencyRequirements;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> dependencyType = projectDependencyPO.dependencyType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ProjectDependencyPO extends SqlTable {
        public final SqlColumn<Integer> dependencyId = column("dependency_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> projectId = column("project_id", JDBCType.INTEGER);

        public final SqlColumn<String> projectName = column("project_name", JDBCType.VARCHAR);

        public final SqlColumn<String> platform = column("platform", JDBCType.VARCHAR);

        public final SqlColumn<String> projectVersion = column("project_version", JDBCType.VARCHAR);

        public final SqlColumn<Integer> dependencyProjectId = column("dependency_project_id", JDBCType.INTEGER);

        public final SqlColumn<String> dependencyProjectName = column("dependency_project_name", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyProjectPlatform = column("dependency_project_platform", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyRequirements = column("dependency_requirements", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyType = column("dependency_type", JDBCType.VARCHAR);

        public ProjectDependencyPO() {
            super("project_dependencies");
        }
    }
}