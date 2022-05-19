package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.MigrationRulePO;
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

    public static MigrationRuleVO build(MigrationRulePO po) {
        return new MigrationRuleVO(po.getRuleId(),
                po.getFromId(),
                po.getToId(),
                po.getConfidence(),
                po.getRuleSup(),
                po.getMsgSup(),
                po.getDisSup(),
                po.getApiSup());
    }

}
