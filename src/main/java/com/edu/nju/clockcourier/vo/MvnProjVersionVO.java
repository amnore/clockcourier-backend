package com.edu.nju.clockcourier.vo;

import java.util.List;

public class MvnProjVersionVO {

    private Integer projectId;

    private String name;

    private String groupId;

    private String artifactId;

    private List<String> licences;

    private String version;

    private List<MvnProjDepVO> dependencies;
}
