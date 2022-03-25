package com.edu.nju.clockcourier.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MvnDependencyPO {

    private Integer projectId;

    private String version;

    private Integer libId;

    private String libVersion;

}