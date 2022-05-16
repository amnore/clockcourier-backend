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
}