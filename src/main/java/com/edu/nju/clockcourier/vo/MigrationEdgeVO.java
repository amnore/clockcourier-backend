package com.edu.nju.clockcourier.vo;

import lombok.Data;

@Data
public class MigrationEdgeVO {

    private Integer num;

    private Double confidence;

    private MigrationGraphVO toLibInfo;

}
