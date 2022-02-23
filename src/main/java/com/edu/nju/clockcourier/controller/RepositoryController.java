package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repository")
public class RepositoryController {

    @PostMapping("/query")
    public ResponseVO<List<RepositoryVO>> query(){
        return null;
    }

    @GetMapping("/{repositoryId}/get")
    public ResponseVO<RepositoryVO> get(@PathVariable String repositoryId){
        return null;
    }

    @PostMapping("/{repositoryId}/dependency/query")
    public ResponseVO<List<RepoDepVO>> queryDependencies(){
        return null;
    }

}
