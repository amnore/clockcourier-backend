package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class ProjDepDSS {

    public static final ProjectDependencyPO projectDependencyPO = new ProjectDependencyPO();

    public static final SqlColumn<Integer> dependencyId = projectDependencyPO.dependencyId;

    public static final SqlColumn<Integer> projectId = projectDependencyPO.projectId;

    public static final SqlColumn<String> projectName = projectDependencyPO.projectName;

    public static final SqlColumn<String> platform = projectDependencyPO.platform;

    public static final SqlColumn<String> projectVersion = projectDependencyPO.projectVersion;

    public static final SqlColumn<Integer> dependencyProjectId = projectDependencyPO.dependencyProjectId;

    public static final SqlColumn<String> dependencyProjectName = projectDependencyPO.dependencyProjectName;

    public static final SqlColumn<String> dependencyProjectPlatform = projectDependencyPO.dependencyProjectPlatform;

    public static final SqlColumn<String> dependencyRequirements = projectDependencyPO.dependencyRequirements;

    public static final SqlColumn<String> dependencyType = projectDependencyPO.dependencyType;

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