package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.vo.MvnLibListVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import com.edu.nju.clockcourier.vo.MvnProjectVO;

import java.util.List;

public interface MvnService {

    MvnLibListVO getMvnLibs(MvnLibFilterDTO filter);

    MvnLibVO getSpecificMvnLib(Integer libId);

    List<MvnLibVO> extractPomDeps(MvnPomAnalyseDTO dto);

    MvnProjectVO getMvnProject(Integer projectId);

}
