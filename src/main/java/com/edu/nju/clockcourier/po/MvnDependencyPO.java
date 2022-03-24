package com.edu.nju.clockcourier.po;

import javax.annotation.Generated;
import lombok.Data;

@Data
public class MvnDependencyPO {

    private Integer projectId;


    private String version;


    private Integer libId;


    private String libVersion;

    private static MvnDependencyPO nullInstance;

    public static MvnDependencyPO getNullInstance() {
        if (nullInstance == null) nullInstance = new MvnDependencyPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MvnDependencyPO po) {
        return po == nullInstance;
    }
}