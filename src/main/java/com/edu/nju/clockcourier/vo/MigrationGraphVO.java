package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MigrationGraphVO {

    private MvnLibVO fromLibInfo;

    private List<MigrationEdgeVO> edges;

}
