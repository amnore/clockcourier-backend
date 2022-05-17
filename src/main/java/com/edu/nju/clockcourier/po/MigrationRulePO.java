package com.edu.nju.clockcourier.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

@Data
@NoArgsConstructor
public class MigrationRulePO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer ruleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer fromId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer toId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Double confidence;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Double ruleSup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Double msgSup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Double disSup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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