package com.edu.nju.clockcourier.vo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
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

    private Integer repositoryUrl;

    private List<String> licenses;
    
}
