package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnProjVersionVO {

    private Integer projectId;

    private String name;

    private String groupId;

    private String artifactId;

    private String version;

    private List<MvnProjDepVO> dependencies;
}
