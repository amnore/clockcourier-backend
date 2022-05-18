package com.edu.nju.clockcourier.po;

import lombok.Data;

@Data
public class MvnProjectPO {
    
    private Integer projectId;

    private String name;

    private String url;

    private static MvnProjectPO nullInstance;

    public static MvnProjectPO getNullInstance() {
        if (nullInstance == null) nullInstance = new MvnProjectPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MvnProjectPO po) {
        return po == nullInstance;
    }
}