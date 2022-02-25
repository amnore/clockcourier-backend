package com.edu.nju.clockcourier.dto;

import lombok.Data;

@Data
public class ProjDepFilterDTO {

    private String projectVersion;

    private String dependencyProjectName;

    private String dependencyProjectPlatform;

    private String dependencyType;

    private Integer page;

    private Boolean isReverse;

}
