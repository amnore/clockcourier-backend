package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.MvnProjPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnNewestProjVO {

    private Integer projectId;

    private String name;

    private String groupId;

    private String artifactId;

    private List<String> versions;

    private String description;

    private String url;

    public static MvnNewestProjVO build(MvnProjPO po, List<String> versions) {
        MvnNewestProjVO vo = new MvnNewestProjVO();
        vo.setProjectId(po.getProjectId());
        vo.setName(po.getName());
        vo.setGroupId(po.getGroupId());
        vo.setArtifactId(po.getArtifactId());
        vo.setVersions(versions);
        vo.setDescription(po.getDescription());
        vo.setUrl(po.getUrl());
        return vo;
    }

}
