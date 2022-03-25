package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.MvnProjPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnProjVO {

    private Integer projectId;

    private String version;

    private String groupId;

    private String artifactId;

    private String name;

    private List<MvnDepVO> dependencies;

    public static MvnProjVO build(MvnProjPO po, List<MvnDepVO> dependencies) {
        return new MvnProjVO(po.getProjectId(),
                po.getVersion(),
                po.getGroupId(),
                po.getArtifactId(),
                po.getName(),
                dependencies);
    }

}
