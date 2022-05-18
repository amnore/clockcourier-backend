package com.edu.nju.clockcourier.po;

import lombok.Data;

@Data
public class RuleInstancePO {

    private Integer ruleId;

    private Integer projectId;

    private String fileName;

    private String startCommitLink;

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