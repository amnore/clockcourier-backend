package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.service.MvnProjService;
import com.edu.nju.clockcourier.vo.MvnProjGraphVO;
import com.edu.nju.clockcourier.vo.MvnProjVO;
import com.edu.nju.clockcourier.vo.MvnProjVersionVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mvn")
public class MvnProjController {

    MvnProjService mvnProjService;

    @Autowired
    public MvnProjController(MvnProjService mvnProjService){
        this.mvnProjService=mvnProjService;
    }

    @PostMapping("/query")
    public ResponseVO<MvnProjVO> query(@RequestBody MvnProjFilterDTO filter){
        return ResponseVO.success(null);
    }

    @GetMapping("/{projectId}/{version}/mvn")
    public ResponseVO<MvnProjVersionVO> getMvn(@PathVariable Integer projectId,@PathVariable String version){
        return ResponseVO.success(null);
    }

    @GetMapping("/{projectId}/graph")
    public ResponseVO<MvnProjGraphVO> getGraph(@PathVariable Integer projectId){
        return ResponseVO.success(null);
    }


}
