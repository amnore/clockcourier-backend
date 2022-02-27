package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepoDepVO {

    private Integer dependencyId;

    private Integer repositoryId;

    private String repositoryName;

    private String repositoryOwner;

    private String hostType;

    private Integer dependencyProjectId;

    private String dependencyProjectName;

    private String dependencyRequirements;

    private String dependencyType;

    public static RepoDepVO build(RepositoryDependencyPO repositoryDependencyPO){
        return new RepoDepVO(
                repositoryDependencyPO.getDependencyId(),
                repositoryDependencyPO.getRepositoryId(),
                repositoryDependencyPO.getRepositoryName(),
                repositoryDependencyPO.getRepositoryOwner(),
                repositoryDependencyPO.getHostType(),
                repositoryDependencyPO.getDependencyProjectId(),
                repositoryDependencyPO.getDependencyProjectName(),
                repositoryDependencyPO.getDependencyRequirements(),
                repositoryDependencyPO.getDependencyType()
        );
    }

}
