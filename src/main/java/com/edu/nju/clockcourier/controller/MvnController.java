package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.constant.ReturnMessage;
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

    @PostMapping("/lib/get")
    public ResponseVO<MvnLibVO> getMvnLib(@RequestBody MvnLibSelectDTO dto) {
        if (!dto.isValid()) throw new CustomException(ReturnMessage.InvalidDTO.getMsg());
        return ResponseVO.success(this.service.getSpecificMvnLib(dto.getGroupId(), dto.getArtifactId()));
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