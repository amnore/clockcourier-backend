package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnProjGraphVO {

    private Integer projectId;

    private String name;

    private List<MvnProjEdge> outEdges;

}
