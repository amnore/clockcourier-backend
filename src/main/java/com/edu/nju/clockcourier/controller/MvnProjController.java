package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.service.MvnProjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mvn")
public class MvnProjController {

    MvnProjService mvnProjService;

    @Autowired
    public MvnProjController(MvnProjService mvnProjService){
        this.mvnProjService=mvnProjService;
    }



}
