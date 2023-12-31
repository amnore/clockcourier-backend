package com.edu.nju.clockcourier.po;

import lombok.Data;

@Data
public class MvnLibPO {

    private Integer libId;

    private String groupId;

    private String artifactId;

    private String mvnCtrUrl;

    private String githubUrl;

    private String description;

    private Integer startRuleNum;

    private static MvnLibPO nullInstance;

    public static MvnLibPO getNullInstance() {
        if (nullInstance == null) nullInstance = new MvnLibPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MvnLibPO po) {
        return po == nullInstance;
    }

}