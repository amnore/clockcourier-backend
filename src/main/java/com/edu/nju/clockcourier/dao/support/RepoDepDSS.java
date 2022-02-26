package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class RepoDepDSS {

    public static final RepositoryDependencies REPOSITORY_DEPENDENCIES = new RepositoryDependencies();

    public static final SqlColumn<Integer> dependencyId = REPOSITORY_DEPENDENCIES.dependencyId;

    public static final SqlColumn<Integer> repositoryId = REPOSITORY_DEPENDENCIES.repositoryId;

    public static final SqlColumn<String> repositoryName = REPOSITORY_DEPENDENCIES.repositoryName;

    public static final SqlColumn<String> repositoryOwner = REPOSITORY_DEPENDENCIES.repositoryOwner;

    public static final SqlColumn<String> hostType = REPOSITORY_DEPENDENCIES.hostType;

    public static final SqlColumn<Integer> dependencyProjectId = REPOSITORY_DEPENDENCIES.dependencyProjectId;

    public static final SqlColumn<String> dependencyProjectName = REPOSITORY_DEPENDENCIES.dependencyProjectName;

    public static final SqlColumn<String> dependencyRequirements = REPOSITORY_DEPENDENCIES.dependencyRequirements;

    public static final SqlColumn<String> dependencyType = REPOSITORY_DEPENDENCIES.dependencyType;

    public static final class RepositoryDependencies extends SqlTable {
        public final SqlColumn<Integer> dependencyId = column("dependency_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> repositoryId = column("repository_id", JDBCType.INTEGER);

        public final SqlColumn<String> repositoryName = column("repository_name", JDBCType.VARCHAR);

        public final SqlColumn<String> repositoryOwner = column("repository_owner", JDBCType.VARCHAR);

        public final SqlColumn<String> hostType = column("host_type", JDBCType.VARCHAR);

        public final SqlColumn<Integer> dependencyProjectId = column("dependency_project_id", JDBCType.INTEGER);

        public final SqlColumn<String> dependencyProjectName = column("dependency_project_name", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyRequirements = column("dependency_requirements", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyType = column("dependency_type", JDBCType.VARCHAR);

        public RepositoryDependencies() {
            super("repository_dependencies");
        }
    }

}