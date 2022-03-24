package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;

import java.util.List;

public interface MvnProjDataService{

    MvnProjectPO getMvnProjVersion(Integer projectId,String version);

    List<MvnDependencyPO> getMvnDep(Integer projectId,String version);

    List<MvnProjectPO> getMvnProj(Integer projectId);

    MvnLibPO getMvnLib(Integer libId);


}
