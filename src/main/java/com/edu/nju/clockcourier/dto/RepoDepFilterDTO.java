package com.edu.nju.clockcourier.dto;

import lombok.Data;

@Data
public class RepoDepFilterDTO {

    private String dependencyProjectName;

    private String dependencyType;

    private Integer page;

    private Boolean isReverse;

}
