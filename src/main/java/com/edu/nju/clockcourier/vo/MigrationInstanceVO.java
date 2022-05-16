package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MigrationInstanceVO {

    private Integer ruleId;

    private String projectName;

    private Integer projectId;

    private String fileName;

    private String projectUrl;

    private String startCommit;

    private String endCommit;

}
