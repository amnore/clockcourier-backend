package com.edu.nju.clockcourier.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MvnDepPO {

    private Integer projectId;

    private String version;

    private Integer libId;

    private String libVersion;

    private static MvnDepPO nullInstance;

    public static MvnDepPO getNullInstance() {
        if (nullInstance == null) nullInstance = new MvnDepPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MvnDepPO po) {
        return po == nullInstance;
    }

}