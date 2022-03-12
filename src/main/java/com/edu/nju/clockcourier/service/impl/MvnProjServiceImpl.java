package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MvnProjDataService;
import com.edu.nju.clockcourier.service.MvnProjService;
import org.springframework.stereotype.Service;

@Service
public class MvnProjServiceImpl implements MvnProjService {

    private final MvnProjDataService mvnProjDataService;

    public MvnProjServiceImpl(MvnProjDataService mvnProjDataService){
        this.mvnProjDataService=mvnProjDataService;
    }
}
