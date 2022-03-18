package com.edu.nju.clockcourier.vo;

import lombok.Data;

import java.util.List;

@Data
public class MvnProjGraphVO {

    private Integer projectId;

    private String name;

    private List<MvnProjEdge> outEdges;

}
