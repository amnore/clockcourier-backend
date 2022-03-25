package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MigrationRuleVO {

    private MvnLibVO mvnLibVO;

    private Integer num;

    private List<MigrationRuleVO> edges;

}
