package com.edu.nju.clockcourier.po;

import lombok.Data;

@Data
public class MigrationRulePO {

    private Integer ruleId;

    private Integer fromId;

    private Integer toId;

    private Double confidence;

    private Double ruleSup;

    private Double msgSup;

    private Double disSup;

    private Double apiSup;

    private static MigrationRulePO nullInstance;

    public static MigrationRulePO getNullInstance() {
        if (nullInstance == null) nullInstance = new MigrationRulePO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MigrationRulePO po) {
        return po == nullInstance;
    }

}