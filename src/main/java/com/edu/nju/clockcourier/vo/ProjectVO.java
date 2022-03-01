package com.edu.nju.clockcourier.vo;


import com.edu.nju.clockcourier.constant.Convention;
import com.edu.nju.clockcourier.po.ProjectPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO {

    private Integer projectId;

    private String projectName;

    private String platform;

    private String language;

    private String description;

    private String homepageUrl;

    private Date createT;

    private Date updateT;

    private Date latestReleaseT;

    private String latestReleaseN;

    private Integer repositoryId;

    private String repositoryUrl;

    private List<String> licenses;

    public static ProjectVO build(ProjectPO project) {
        List<String> list = (Convention.isNull(project.getLicenses())
                ? null
                : List.of(project.getLicenses().split(",")));
        return new ProjectVO(
                project.getProjectId(),
                project.getProjectName(),
                project.getPlatform(),
                project.getLanguage(),
                project.getDescription(),
                project.getHomepageUrl(),
                project.getCreateTimestamp(),
                project.getUpdateTimestamp(),
                project.getLatestReleasePublishTimestamp(),
                project.getLatestReleaseNumber(),
                project.getRepositoryId(),
                project.getRepositoryUrl(),
                list);
    }

}
