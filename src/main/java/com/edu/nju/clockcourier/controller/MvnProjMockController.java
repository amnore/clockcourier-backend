package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.MvnLibDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.service.MvnProjService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project/mvn/mock")
public class MvnProjMockController {

    private final MvnProjService mvnProjService;

    @Autowired
    public MvnProjMockController(MvnProjService mvnProjService) {
        this.mvnProjService = mvnProjService;
    }

    @PostMapping("/query")
    public ResponseVO<MvnProjListVO> query(@RequestBody MvnProjFilterDTO filter) {
        MvnProjVO mock = new MvnProjVO();
        mock.setName("mock");
        mock.setDescription("mock object");
        mock.setArtifactId("mock");
        mock.setGroupId("com.example");
        List<MvnProjVO> projVOS = new ArrayList<>();
        projVOS.add(mock);
        MvnProjListVO listMock = new MvnProjListVO();
        listMock.setPageAll(1);
        listMock.setProjects(projVOS);
        return ResponseVO.success(mvnProjService.query(filter));
    }

    @GetMapping("/{projectId}/get")
    public ResponseVO<MvnProjVersionVO> getMvn(@PathVariable Integer projectId,
                                               @RequestParam String version) {
        MvnProjVersionVO mock = new MvnProjVersionVO();
        mock.setProjectId(projectId);
        mock.setVersion(version);
        mock.setArtifactId("mock");
        mock.setGroupId("com.example");
        return ResponseVO.success(mock);
    }

    @GetMapping("/{projectId}/graph")
    public ResponseVO<MigrationRuleVO> getGraph(@PathVariable Integer libId) {
        MigrationRuleVO mock = new MigrationRuleVO();
//        mock.setProjectId(libId);
//        mock.setName("mock");
//        MigrationRuleVO edgeMock = new MigrationRuleVO();
//        edgeMock.setLibId(2);
//        edgeMock.setWeight(0.1);
//        List<MigrationRuleVO> mockList = new ArrayList<>();
//        mockList.add(edgeMock);
//        mock.setOutEdges(mockList);
        return ResponseVO.success(mock);
    }

    @GetMapping("/{projectId}/base")
    public ResponseVO<MvnProjVO> get(@PathVariable Integer projectId) {
        return ResponseVO.success(null);
    }


    @GetMapping("/lib")
    public ResponseVO<MvnLibVO> getLib(@RequestBody MvnLibDTO mvnLibDTO) {
        return ResponseVO.success(null);
    }

}
