package com.edu.nju.clockcourier.vo;

import com.edu.nju.clockcourier.po.MvnProjectPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MvnProjectVO {

    private Integer projectId;

    private String name;

    private String url;

    public static MvnProjectVO build(MvnProjectPO po) {
        return new MvnProjectVO(po.getProjectId(), po.getName(), po.getUrl());
    }

}
