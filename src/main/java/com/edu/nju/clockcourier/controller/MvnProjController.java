package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.service.MvnProjService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mvn")
public class MvnProjController {

    private final MvnProjService mvnProjService;

    @Autowired
    public MvnProjController(MvnProjService mvnProjService) {
        this.mvnProjService = mvnProjService;
    }

    @PostMapping("/query")
    public ResponseVO<MvnProjVO> query(@RequestBody MvnProjFilterDTO filter) {
        MvnProjVO mock = new MvnProjVO();
        mock.setName("mock");
        mock.setDescription("mock object");
        mock.setArtifactId("mock");
        mock.setGroupId("com.example");
        return ResponseVO.success(mock);
    }

    @GetMapping("/{projectId}/{version}/mvn")
    public ResponseVO<MvnProjVersionVO> getMvn(@PathVariable Integer projectId, @PathVariable String version) {
        MvnProjVersionVO mock = new MvnProjVersionVO();
        mock.setProjectId(projectId);
        mock.setVersion(version);
        mock.setArtifactId("mock");
        mock.setGroupId("com.example");
        return ResponseVO.success(mock);
    }

    @GetMapping("/{projectId}/graph")
    public ResponseVO<MvnProjGraphVO> getGraph(@PathVariable Integer projectId) {
        MvnProjGraphVO mock = new MvnProjGraphVO();
        mock.setProjectId(projectId);
        mock.setName("mock");
        MvnProjEdge edgeMock = new MvnProjEdge();
        edgeMock.setProjectId(2);
        edgeMock.setWeight(0.1);
        List<MvnProjEdge> mockList = new ArrayList<>();
        mockList.add(edgeMock);
        mock.setOutEdges(mockList);
        return ResponseVO.success(mock);
    }

}
