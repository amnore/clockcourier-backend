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

    //原来的数据库中出现拼写错误，decription，已修复
    private String description;

    private String homepageUrl;

    private Date createTimestamp;

    private Date updateTimestamp;

    private Date latestPushTimestamp;

    //由于Mysql无法设置为Boolean，因此改为Integer
    private Integer fork;

    private Integer forkCount;

    private Integer watcherCount;

    private Integer starCount;

    private Integer contributorCount;

    private Integer openIssueCount;

    private String defaultBranch;

    private String licenses;

}
