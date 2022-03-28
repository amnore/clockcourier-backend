package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MigrationEdgeVO {

    private Integer libId;

    private Double confidence;

    private Integer num;

}
