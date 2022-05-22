package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.MvnLibPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnLibVO {

    private Integer libId;

    private String groupId;

    private String artifactId;

    private String mvnCtrUrl;

    private String repoUrl;

    private String description;

    public static MvnLibVO build(MvnLibPO mvnLibPO) {
        // github_url -> repo_url, 历史遗留问题...
        return new MvnLibVO(mvnLibPO.getLibId(),
                mvnLibPO.getGroupId(),
                mvnLibPO.getArtifactId(),
                mvnLibPO.getMvnCtrUrl(),
                mvnLibPO.getGithubUrl(),
                mvnLibPO.getDescription());
    }

}
