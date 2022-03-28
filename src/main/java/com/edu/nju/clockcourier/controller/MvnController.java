package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnLibSelectDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/mvn")
public class MvnController {

    private final MvnService service;

    @Autowired
    public MvnController(MvnService service) {
        this.service = service;
    }

    @GetMapping("/lib/get/{libId}")
    public ResponseVO<MvnLibVO> getMvnLib(@PathVariable("libId") Integer libId) {
        return ResponseVO.success(this.service.getSpecificMvnLib(libId));
    }

    @PostMapping("/lib/query")
    public ResponseVO<MvnLibListVO> getMvnLibList(@RequestBody MvnLibFilterDTO dto){
        return ResponseVO.success(this.service.getMvnLibs(dto));
    }

    @PostMapping("/query")
    public ResponseVO<MvnProjListVO> getMvnProjList(@RequestBody MvnProjFilterDTO dto) {
        return ResponseVO.success(this.service.getMvnProjects(dto));
    }

    @GetMapping("/{projectId}/get")
    public ResponseVO<MvnNewestProjVO> getNewestMvnProj(@PathVariable String projectId) {
        return ResponseVO.success(this.service.getNewestMvnProj(Integer.parseInt(projectId)));
    }

    @GetMapping("/{projectId}/get/{version}")
    public ResponseVO<MvnProjVO> getNewestMvnProj(@PathVariable("projectId") String projectId, @PathVariable("version") String version) {
        return ResponseVO.success(this.service.getSpecificMvnProj(Integer.parseInt(projectId), version));
    }

}
