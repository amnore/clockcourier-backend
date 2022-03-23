package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project/mvn/mock")
public class MvnProjMockController {

    @PostMapping("/query")
    public ResponseVO<MvnProjVO> query(@RequestBody MvnProjFilterDTO filter) {
        MvnProjVO mock = new MvnProjVO();
        mock.setName("mock");
        mock.setDescription("mock object");
        mock.setArtifactId("mock");
        mock.setGroupId("com.example");
        return ResponseVO.success(mock);
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

    @GetMapping("/{projectId}/base")
    public ResponseVO<MvnProjVO> get(@PathVariable Integer projectId){
        return ResponseVO.success(null);
    }

}
