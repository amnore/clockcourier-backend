package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import com.edu.nju.clockcourier.vo.MvnNewestProjVO;
import com.edu.nju.clockcourier.vo.MvnProjListVO;
import com.edu.nju.clockcourier.vo.MvnProjVO;

public interface MvnService {

    MvnProjListVO getMvnProjects(MvnProjFilterDTO filter);

    MvnProjVO getSpecificMvnProj(Integer projectId, String version);

    MvnNewestProjVO getNewestMvnProj(Integer projectId);

    MvnLibVO getSpecificMvnLib(String groupId, String artifactId);

    MvnLibVO getSpecificMvnLib(Integer libId);

}
