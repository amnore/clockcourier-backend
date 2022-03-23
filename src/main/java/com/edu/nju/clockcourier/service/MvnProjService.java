package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.vo.MvnProjGraphVO;
import com.edu.nju.clockcourier.vo.MvnProjListVO;
import com.edu.nju.clockcourier.vo.MvnProjVO;
import com.edu.nju.clockcourier.vo.MvnProjVersionVO;

public interface MvnProjService {

    MvnProjListVO query(MvnProjFilterDTO filter);

    MvnProjVersionVO getMvn(Integer projectId,String version);

    MvnProjGraphVO getGraph(Integer projectId);

    MvnProjVO getBase(Integer projectId);

}
