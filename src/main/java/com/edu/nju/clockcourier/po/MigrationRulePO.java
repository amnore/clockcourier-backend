package com.edu.nju.clockcourier.po;

import javax.annotation.Generated;
import lombok.Data;

@Data
public class MigrationRulePO {

    private Integer fromId;


    private Integer toId;


    private Integer projectId;


    private String version;


    private Double confidence;
}