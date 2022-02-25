package com.edu.nju.clockcourier.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjDepVO {

    private Integer dependencyId;

    private Integer projectId;

    private String projectName;

    private String platform;

    private String projectVersion;

    private Integer dependencyProjectId;

    private String dependencyProjectName;

    private String dependencyProjectPlatform;

    private String dependencyRequirements;

    private String dependencyType;

}
