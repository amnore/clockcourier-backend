package com.edu.nju.clockcourier.controller;


import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @PostMapping("/query")
    public ResponseVO<ProjectListVO> query(@RequestBody ProjFilterDTO filter) {
        return ResponseVO.success(null);
    }

    @GetMapping("/{projectId}/get")
    public ResponseVO<ProjectVO> get(@PathVariable String projectId) {
        return ResponseVO.success(null);
    }

    @PostMapping("/{projectId}/dependency/query")
    public ResponseVO<RepoDepListVO> queryDependencies(@PathVariable String projectId,
                                                       @RequestBody ProjDepFilterDTO filter) {
        return ResponseVO.success(null);
    }

}
