package com.edu.nju.clockcourier.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RepositoryPO {

    private Integer repositoryId;

    private String hostType;

    private String repositoryName;

    private String repositoryOwner;

    private String language;

    private String description;

    private String homepageUrl;

    private Date createTimestamp;

    private Date updateTimestamp;

    private Date lastPushTimestamp;

    private Boolean fork;

    private Integer forkCount;

    private Integer watcherCount;

    private Integer starCount;

    private Integer contributorCount;

    private Integer openIssueCount;

    private String defaultBranch;

    private String licenses;
}
