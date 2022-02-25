package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.service.RepositoryService;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/repository")
public class RepositoryController {

    @Resource
    RepositoryService repositoryService;

    @PostMapping("/query")
    public ResponseVO<RepositoryListVO> query(@RequestBody RepoFilterDTO filter) {
        return ResponseVO.success(null);
    }

    @GetMapping("/{repositoryId}/get")
    public ResponseVO<RepositoryVO> get(@PathVariable String repositoryId) {
        return ResponseVO.success(repositoryService.getRepository(Integer.parseInt(repositoryId)));
    }

    @PostMapping("/{repositoryId}/dependency/query")
    public ResponseVO<RepoDepListVO> queryDependencies(@PathVariable String repositoryId,
                                                       @RequestBody RepoDepFilterDTO filter) {
        return ResponseVO.success(null);
    }

}
