package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.RepositoryPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryVO {

    private Integer repositoryId;

    private String hostType;

    private String repositoryName;

    private String repositoryOwner;

    private String language;

    private String description;

    private String homepageUrl;

    private Date createT;

    private Date updateT;

    private Date latestPushT;

    private Boolean canFork;

    private Integer forkCount;

    private Integer watcherCount;

    private Integer starCount;

    private Integer contributorCount;

    private Integer openIssueCount;

    private String defaultBranch;

    private List<String> licenses;

    public static RepositoryVO Build(RepositoryPO repository){
        boolean fork;
        if(repository.getFork()==1)fork=true;
        else fork=false;
        return new RepositoryVO(repository.getRepositoryId(),
                                repository.getHostType(),
                                repository.getRepositoryName(),
                                repository.getRepositoryOwner(),
                                repository.getLanguage(),
                                repository.getDescription(),
                                repository.getHomepageUrl(),
                                repository.getCreateTimestamp(),
                                repository.getUpdateTimestamp(),
                                repository.getLatestPushTimestamp(),
                                fork,
                                repository.getForkCount(),
                                repository.getWatcherCount(),
                                repository.getStarCount(),
                                repository.getContributorCount(),
                                repository.getOpenIssueCount(),
                                repository.getDefaultBranch(),
                                new ArrayList<String>(Arrays.asList(repository.getLicenses())));

    }
    
}
