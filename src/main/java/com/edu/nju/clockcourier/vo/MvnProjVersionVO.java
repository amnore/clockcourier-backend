package com.edu.nju.clockcourier.vo;

import lombok.Data;

import java.util.List;

@Data
public class MvnProjVersionVO {

    private Integer projectId;

    private String name;

    private String groupId;

    private String artifactId;

    private String version;

    private List<MvnProjDepVO> dependencies;
}
