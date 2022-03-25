package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
import org.springframework.data.util.Pair;

import java.util.List;

public interface MvnDataService {

    // mvn_libs
    void insertMvnLib(MvnLibPO po);

    MvnLibPO getMvnLib(String groupId, String artifactId);

    MvnLibPO getMvnLib(Integer libId);

    // mvn_projects
    void insertMvnProjIfNotExists(MvnProjPO po);

    Integer getMvnProjIdIfExists(String groupId, String artifactId);

    MvnProjPO getMvnProj(Integer projectId, String version);

    MvnProjPO getNewestMvnProj(Integer projectId);

    List<MvnProjPO> allMvnProjWithMultiVersions();

    Pair<List<MvnProjPO>, Integer> allMvnProjAndFilterNewest(MvnProjFilterDTO filter, int pageSize);

    List<String> allMvnProjVersions(Integer projectId);

    // mvn_dependencies
    void insertMvnDepIfNotExists(MvnDepPO po);

    List<MvnDepPO> allMvnDeps(Integer projectId, String version);

}
