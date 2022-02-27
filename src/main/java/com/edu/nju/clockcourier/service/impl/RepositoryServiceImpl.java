package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.ConstConfig;
import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import com.edu.nju.clockcourier.service.RepositoryService;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryDataService repositoryDataService;
    private final ConstConfig config;

    @Autowired
    public RepositoryServiceImpl(RepositoryDataService repositoryDataService,ConstConfig config) {
        this.repositoryDataService = repositoryDataService;
        this.config=config;
    }

    @Override
    public RepositoryVO getRepository(Integer id) {
        return RepositoryVO.build(repositoryDataService.getRepository(id));
    }

    @Override
    public RepositoryListVO getRepositories(RepoFilterDTO filter) {
        int pageSize = Integer.parseInt(config.getPageSize());
        List<RepositoryVO> vos= repositoryDataService.allAndFilter(filter,pageSize)
                .stream()
                .map(RepositoryVO::build)
                .collect(Collectors.toList());
        return new RepositoryListVO(filter.getPage(),pageSize,vos);
    }

    @Override
    public RepoDepListVO getDependencies(Integer repositoryId, RepoDepFilterDTO filter) {
        int pageSize = Integer.parseInt(config.getPageSize());
        List<RepoDepVO> vos=repositoryDataService.depAndFilter(repositoryId,filter,pageSize)
                .stream()
                .map(RepoDepVO::build)
                .collect(Collectors.toList());
        return new RepoDepListVO(filter.getPage(), pageSize,vos);
    }

}
