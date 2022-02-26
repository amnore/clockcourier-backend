package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class ProjDepDSS {

    public static final ProjectDependencies PROJECT_DEPENDENCIES = new ProjectDependencies();

    public static final SqlColumn<Integer> dependencyId = PROJECT_DEPENDENCIES.dependencyId;

    public static final SqlColumn<Integer> projectId = PROJECT_DEPENDENCIES.projectId;

    public static final SqlColumn<String> projectName = PROJECT_DEPENDENCIES.projectName;

    public static final SqlColumn<String> platform = PROJECT_DEPENDENCIES.platform;

    public static final SqlColumn<String> projectVersion = PROJECT_DEPENDENCIES.projectVersion;

    public static final SqlColumn<Integer> dependencyProjectId = PROJECT_DEPENDENCIES.dependencyProjectId;

    public static final SqlColumn<String> dependencyProjectName = PROJECT_DEPENDENCIES.dependencyProjectName;

    public static final SqlColumn<String> dependencyProjectPlatform = PROJECT_DEPENDENCIES.dependencyProjectPlatform;

    public static final SqlColumn<String> dependencyRequirements = PROJECT_DEPENDENCIES.dependencyRequirements;

    public static final SqlColumn<String> dependencyType = PROJECT_DEPENDENCIES.dependencyType;

    public static final class ProjectDependencies extends SqlTable {
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

        public ProjectDependencies() {
            super("project_dependencies");
        }
    }

}