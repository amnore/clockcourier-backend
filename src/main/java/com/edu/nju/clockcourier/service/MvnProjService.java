package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.vo.*;

public interface MvnProjService {

    MvnProjListVO query(MvnProjFilterDTO filter);

    MvnProjVersionVO getMvn(Integer projectId, String version);

    MigrationRuleVO getGraph(Integer libId);

    MvnProjVO getBase(Integer projectId);

    MvnLibVO getLib(String groupId, String artifactId);

}
