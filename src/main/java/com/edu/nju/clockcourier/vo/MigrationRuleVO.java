package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MigrationRuleVO {

    private Integer ruleId;

    private Integer fromId;

    private Integer toId;

    private Double confidence;

    private Double rs;

    private Double ms;

    private Double ds;

    private Double as;

}
