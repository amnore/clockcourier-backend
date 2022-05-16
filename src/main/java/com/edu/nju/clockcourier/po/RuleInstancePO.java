package com.edu.nju.clockcourier.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

@Data
@NoArgsConstructor
public class RuleInstancePO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer ruleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer projectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String fileName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String startCommitLink;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String endCommitLink;
}