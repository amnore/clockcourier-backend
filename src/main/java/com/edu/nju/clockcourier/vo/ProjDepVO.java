package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.ProjectDependencyPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public static ProjDepVO build(ProjectDependencyPO projectDependencyPO){
        return new ProjDepVO(
                projectDependencyPO.getDependencyId(),
                projectDependencyPO.getProjectId(),
                projectDependencyPO.getProjectName(),
                projectDependencyPO.getDependencyProjectPlatform(),
                projectDependencyPO.getProjectVersion(),
                projectDependencyPO.getDependencyProjectId(),
                projectDependencyPO.getDependencyProjectName(),
                projectDependencyPO.getDependencyProjectPlatform(),
                projectDependencyPO.getDependencyRequirements(),
                projectDependencyPO.getDependencyType()
        );
    }

}
