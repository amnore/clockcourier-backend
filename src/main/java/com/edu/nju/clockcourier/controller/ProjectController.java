package com.edu.nju.clockcourier.controller;


import com.edu.nju.clockcourier.vo.ProjDepVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @PostMapping("/query")
    public ResponseVO<List<ProjectVO>> query(){
        return null;
    }

    @GetMapping("/{projectId}/get")
    public ResponseVO<ProjectVO> get(@PathVariable String projectId){
        return null;
    }

    @PostMapping("/{projectId}/dependency/query")
    public ResponseVO<RepoDepVO> queryDependencies(@PathVariable String projectId){
        return null;
    }

}
