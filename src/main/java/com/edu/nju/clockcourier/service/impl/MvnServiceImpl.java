package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.MvnProjGraphVO;
import com.edu.nju.clockcourier.vo.MvnProjListVO;
import com.edu.nju.clockcourier.vo.MvnProjVO;
import com.edu.nju.clockcourier.vo.MvnProjVersionVO;
import org.springframework.stereotype.Service;

@Service
public class MvnServiceImpl implements MvnService {

    private final MvnDataService mvnDataService;

    public MvnServiceImpl(MvnDataService mvnDataService) {
        this.mvnDataService = mvnDataService;
    }

    @Override
    public MvnProjListVO query(MvnProjFilterDTO filter) {
        return null;
    }

    @Override
    public MvnProjVersionVO getMvn(Integer projectId, String version) {
        return null;
    }

    @Override
    public MvnProjGraphVO getGraph(Integer projectId) {
        return null;
    }

    @Override
    public MvnProjVO getBase(Integer projectId) {
        return null;
    }
}
