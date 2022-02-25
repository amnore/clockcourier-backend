package com.edu.nju.clockcourier.dao.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class RepoDepDSS {

    public static final RepositoryDependencyPO repositoryDependencyPO = new RepositoryDependencyPO();

    public static final SqlColumn<Integer> dependencyId = repositoryDependencyPO.dependencyId;

    public static final SqlColumn<Integer> repositoryId = repositoryDependencyPO.repositoryId;

    public static final SqlColumn<String> repositoryName = repositoryDependencyPO.repositoryName;

    public static final SqlColumn<String> repositoryOwner = repositoryDependencyPO.repositoryOwner;

    public static final SqlColumn<String> hostType = repositoryDependencyPO.hostType;

    public static final SqlColumn<Integer> dependencyProjectId = repositoryDependencyPO.dependencyProjectId;

    public static final SqlColumn<String> dependencyProjectName = repositoryDependencyPO.dependencyProjectName;

    public static final SqlColumn<String> dependencyRequirements = repositoryDependencyPO.dependencyRequirements;

    public static final SqlColumn<String> dependencyType = repositoryDependencyPO.dependencyType;

    public static final class RepositoryDependencyPO extends SqlTable {
        public final SqlColumn<Integer> dependencyId = column("dependency_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> repositoryId = column("repository_id", JDBCType.INTEGER);

        public final SqlColumn<String> repositoryName = column("repository_name", JDBCType.VARCHAR);

        public final SqlColumn<String> repositoryOwner = column("repository_owner", JDBCType.VARCHAR);

        public final SqlColumn<String> hostType = column("host_type", JDBCType.VARCHAR);

        public final SqlColumn<Integer> dependencyProjectId = column("dependency_project_id", JDBCType.INTEGER);

        public final SqlColumn<String> dependencyProjectName = column("dependency_project_name", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyRequirements = column("dependency_requirements", JDBCType.VARCHAR);

        public final SqlColumn<String> dependencyType = column("dependency_type", JDBCType.VARCHAR);

        public RepositoryDependencyPO() {
            super("repository_dependencies");
        }
    }
    
}