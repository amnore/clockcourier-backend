package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.MvnLibPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnDepVO {

    private Integer libId;

    private String groupId;

    private String artifactId;

    private String version;

    public static MvnDepVO build(MvnLibPO po, String version) {
        return new MvnDepVO(po.getLibId(),
                po.getGroupId(),
                po.getArtifactId(),
                version);
    }

}
