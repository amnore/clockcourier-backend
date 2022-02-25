package com.edu.nju.clockcourier.controller;


import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.service.ProjectService;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    ProjectService projectService;

    @PostMapping("/query")
    public ResponseVO<ProjectListVO> query(@RequestBody ProjFilterDTO filter) {
        return ResponseVO.success(null);
    }

    @GetMapping("/{projectId}/get")
    public ResponseVO<ProjectVO> get(@PathVariable String projectId) {
        return ResponseVO.<ProjectVO>success(projectService.getProject(Integer.parseInt(projectId)));
    }

    @PostMapping("/{projectId}/dependency/query")
    public ResponseVO<RepoDepListVO> queryDependencies(@PathVariable String projectId,
                                                       @RequestBody ProjDepFilterDTO filter) {
        return ResponseVO.success(null);
    }

}
