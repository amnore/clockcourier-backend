package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.service.RepositoryService;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repository")
public class RepositoryController {

    RepositoryService repositoryService;

    @Autowired
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @PostMapping("/query")
    public ResponseVO<RepositoryListVO> query(@RequestBody RepoFilterDTO filter) {
        return ResponseVO.success(repositoryService.getRepositories(filter));
    }

    @GetMapping("/{repositoryId}/get")
    public ResponseVO<RepositoryVO> get(@PathVariable String repositoryId) {
        return ResponseVO.success(repositoryService.getRepository(Integer.parseInt(repositoryId)));
    }

    @PostMapping("/{repositoryId}/dependency/query")
    public ResponseVO<RepoDepListVO> queryDependencies(@PathVariable String repositoryId,
                                                       @RequestBody RepoDepFilterDTO filter) {
        return ResponseVO.success(repositoryService.getDependencies(Integer.parseInt(repositoryId),filter));
    }

}
