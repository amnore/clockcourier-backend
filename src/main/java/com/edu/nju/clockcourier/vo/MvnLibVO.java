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

    public static MvnLibVO build(MvnLibPO mvnLibPO) {
        return new MvnLibVO(mvnLibPO.getLibId()
                , mvnLibPO.getGroupId()
                , mvnLibPO.getArtifactId());
    }
}
