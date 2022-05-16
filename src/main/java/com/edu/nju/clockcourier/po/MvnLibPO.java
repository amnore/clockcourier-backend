package com.edu.nju.clockcourier.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MvnLibPO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer libId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String groupId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String artifactId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String mvnCtrUrl;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String githubUrl;

    private static MvnLibPO nullInstance;

    public static MvnLibPO getNullInstance() {
        if (nullInstance == null) nullInstance = new MvnLibPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(MvnLibPO po) {
        return po == nullInstance;
    }

    public MvnLibPO(String groupId, String artifactId) {
        this.groupId = groupId;
        this.artifactId = artifactId;
    }
}