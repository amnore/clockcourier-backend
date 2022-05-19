package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.MvnLibListVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/mvn")
public class MvnLibraryController {

    private final MvnService service;

    @Autowired
    public MvnLibraryController(MvnService mvnService) {
        this.service = mvnService;
    }

    @GetMapping("/{libId}/get")
    public ResponseVO<MvnLibVO> getMvnLib(@PathVariable("libId") Integer libId) {
        return ResponseVO.success(this.service.getSpecificMvnLib(libId));
    }

    @PostMapping("/query")
    public ResponseVO<MvnLibListVO> getMvnLibList(@RequestBody MvnLibFilterDTO dto) {
        return ResponseVO.success(this.service.getMvnLibs(dto));
    }

    @PostMapping("/pom/analyse")
    public ResponseVO<List<MvnLibVO>> analysePom(@RequestBody MvnPomAnalyseDTO dto) {
        return ResponseVO.success(this.service.extractPomDeps(dto));
    }

}
