package com.edu.nju.clockcourier.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProjectPO {

    private Integer projectId;

    private String projectName;

    private String platform;

    private String language;

    private String description;

    private String homepageUrl;

    private Date createTimestamp;

    private Date updateTimestamp;

    private Date lastReleasePublishTimestamp;

    private String latestReleaseNumber;

    private Integer repositoryId;

    private String repositoryUrl;

    private String licenses;
}
