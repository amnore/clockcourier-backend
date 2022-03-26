package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.vo.*;

public interface MvnService {

    MvnProjListVO getMvnProjects(MvnProjFilterDTO filter);

    MvnLibListVO getMvnLibs(MvnLibFilterDTO filter);

    MvnProjVO getSpecificMvnProj(Integer projectId, String version);

    MvnNewestProjVO getNewestMvnProj(Integer projectId);

    MvnLibVO getSpecificMvnLib(String groupId, String artifactId);

    MvnLibVO getSpecificMvnLib(Integer libId);

}
