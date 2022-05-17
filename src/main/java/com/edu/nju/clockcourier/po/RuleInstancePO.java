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

    private static RuleInstancePO nullInstance;

    public static RuleInstancePO getNullInstance() {
        if (nullInstance == null) nullInstance = new RuleInstancePO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(RuleInstancePO po) {
        return po == nullInstance;
    }
}