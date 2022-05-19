package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MigrationNodeVO {

    private MvnLibVO fromLibInfo;

    private List<MigrationRuleVO> edges;

    public static MigrationNodeVO build(MvnLibVO lib, List<MigrationRuleVO> edges) {
        return new MigrationNodeVO(lib, edges);
    }

}
