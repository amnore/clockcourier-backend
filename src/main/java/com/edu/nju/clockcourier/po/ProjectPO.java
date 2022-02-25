package com.edu.nju.clockcourier.po;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectPO {

    private Integer projectId;

    private String projectName;

    private String platform;

    private String language;

    private String description;

    private String homepageUrl;

    private Date createTimestamp;

    private Date updateTimestamp;

    private Date latestReleasePublishTimestamp;

    private String latestReleaseNumber;

    private Integer repositoryId;

    private String repositoryUrl;

    private String licenses;

    private static ProjectPO nullInstance;

    public static ProjectPO getNullInstance() {
        if (nullInstance == null) nullInstance = new ProjectPO();
        return nullInstance;
    }

    // 通过是否是同一个对象来判断是否是 null instance
    public static boolean isNullInstance(ProjectPO po) {
        return po == nullInstance;
    }

}
