package com.edu.nju.clockcourier.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvnProjDepVO {

    private Integer projectId;

    private String groupId;

    private String artifactId;

    private String version;
    
}
