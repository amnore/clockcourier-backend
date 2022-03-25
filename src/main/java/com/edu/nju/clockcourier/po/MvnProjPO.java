package com.edu.nju.clockcourier.po;

import lombok.Data;

@Data
public class MvnProjPO {

    private Integer projectId;

    private String version;

    private String groupId;

    private String artifactId;

    private String name;

    private String url;

    private String description;

    private static MvnProjPO nullInstance;

    public static MvnProjPO getNullInstance() {
        if (nullInstance == null) nullInstance = new MvnProjPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MvnProjPO po) {
        return po == nullInstance;
    }

}