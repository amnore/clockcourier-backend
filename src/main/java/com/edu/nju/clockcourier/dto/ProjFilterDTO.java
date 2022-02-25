package com.edu.nju.clockcourier.dto;

import com.edu.nju.clockcourier.constant.ProjSortRule;
import lombok.Data;

@Data
public class ProjFilterDTO {

    private String name;

    private String platform;

    private String language;

    private String homepageUrl;

    private String latestReleaseN;

    private Integer page;

    private ProjSortRule sort;

    private Boolean isReverse;

}
