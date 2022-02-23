package com.edu.nju.clockcourier.dto;

import com.edu.nju.clockcourier.constant.RepoSortRule;

public class RepoFilterDTO {

    private String hostType;

    private String repositoryName;

    private String repositoryOwner;

    private String language;

    private String homepageUrl;

    private Boolean canFork;

    private Integer page;

    private RepoSortRule sort;

    private Boolean isReverse;

}
