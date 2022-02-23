package com.edu.nju.clockcourier.dto;

import com.edu.nju.clockcourier.constant.DepType;

public class ProjDepFilterDTO {

    private String projectVersion;

    private String dependencyProjectName;

    private String dependencyProjectPlatform;

    private DepType dependencyType;

    private Integer page;

    private Boolean isReverse;

}
