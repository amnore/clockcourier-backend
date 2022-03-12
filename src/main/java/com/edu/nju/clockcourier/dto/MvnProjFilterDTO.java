package com.edu.nju.clockcourier.dto;

import com.edu.nju.clockcourier.constant.MvnProjSortRule;
import lombok.Data;

@Data
public class MvnProjFilterDTO {

    private String name;

    private String groupId;

    private String artifactId;

    private MvnProjSortRule sort;

    private Boolean isReverse;

    private Integer startIndex;

    private Integer endIndex;
}
