package com.edu.nju.clockcourier.vo;

import lombok.Data;

import java.util.List;

@Data
public class MigrationGraphVO {

    private MvnLibVO fromLibInfo;

    private List<MigrationEdgeVO> edges;

}
