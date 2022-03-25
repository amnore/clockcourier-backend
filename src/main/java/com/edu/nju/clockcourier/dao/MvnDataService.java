package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;

import java.util.List;

public interface MvnDataService {

    // mvn_libs
    void insertLib(MvnLibPO po);

    MvnLibPO findLib(String groupId, String artifactId);

    // mvn_projects
    void insertMvnProjIfNotExists(MvnProjectPO po);

    Integer getMvnProjIdIfExists(String groupId, String artifactId);

    List<MvnProjectPO> allMvnProjWithMultiVersions();

    // mvn_dependencies
    void insertMvnDepIfNotExists(MvnDependencyPO po);

    List<MvnDependencyPO> allMvnDep(Integer projectId, String version);

}
