package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.constant.DepType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RepoDepVO {

    private Integer dependencyId;

    private Integer repositoryId;

    private String repositoryName;

    private String repositoryOwner;

    private String hostType;

    private Integer dependencyProjectId;

    private String dependencyProjectName;

    private String dependencyRequirements;

    private DepType dependencyType;

}
