package com.edu.nju.clockcourier.po;

import lombok.Data;

@Data
public class RepositoryDependencyPO {

    private Integer dependencyId;

    private Integer repositoryId;

    private String repositoryName;

    private String repositoryOwner;

    private String hostType;

    private Integer dependencyProjectId;

    private String dependencyProjectName;

    private String dependencyRequirements;

    private String dependencyType;
}
