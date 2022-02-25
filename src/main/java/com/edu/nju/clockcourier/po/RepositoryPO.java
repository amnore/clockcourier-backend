package com.edu.nju.clockcourier.po;

import lombok.Data;

import java.util.Date;

@Data
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

    private Date latestPushTimestamp;

    private Integer fork;

    private Integer forkCount;

    private Integer watcherCount;

    private Integer starCount;

    private Integer contributorCount;

    private Integer openIssueCount;

    private String defaultBranch;

    private String licenses;

    private static RepositoryPO nullInstance;

    public static RepositoryPO getNullInstance() {
        if (nullInstance == null) nullInstance = new RepositoryPO();
        return nullInstance;
    }

    public static boolean isNullInstance(RepositoryPO po) {
        return po == nullInstance;
    }

}
