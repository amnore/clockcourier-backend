package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MigrationNodeVO {

    private MvnLibVO fromLibInfo;

    private double transitiveConfidence;

    private List<MigrationRuleVO> edges;

}
