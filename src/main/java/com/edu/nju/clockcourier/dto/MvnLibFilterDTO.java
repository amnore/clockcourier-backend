package com.edu.nju.clockcourier.dto;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import lombok.Data;

@Data
public class MvnLibFilterDTO {

    private String groupId;

    private String artifactId;

    private MvnLibSortRule sort;

    private Boolean isReverse;

    private Integer startIndex;

    private Integer endIndex;
    
}
