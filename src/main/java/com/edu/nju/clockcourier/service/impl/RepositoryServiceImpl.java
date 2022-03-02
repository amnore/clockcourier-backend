package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import com.edu.nju.clockcourier.service.RepositoryService;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryDataService repositoryDataService;
    private final DatabaseConfig config;

    @Autowired
    public RepositoryServiceImpl(RepositoryDataService repositoryDataService,
                                 DatabaseConfig config) {
        this.repositoryDataService = repositoryDataService;
        this.config = config;
    }

    @Override
    public RepositoryVO getRepository(Integer id) {
        RepositoryPO po = repositoryDataService.getRepository(id);
        if (RepositoryPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchRepoExp.getMsg());
        return RepositoryVO.build(po);
    }

    @Override
    public RepositoryListVO getRepositories(RepoFilterDTO filter) {
        int pageSize = Integer.parseInt(config.getPageSize());
        Pair<List<RepositoryPO>, Integer> p=repositoryDataService.allAndFilter(filter, pageSize);
        List<RepositoryVO> vos = p.getFirst()
                .stream()
                .map(RepositoryVO::build)
                .collect(Collectors.toList());
        return new RepositoryListVO(filter.getPage(), pageSize, vos);
    }

    @Override
    public RepoDepListVO getDependencies(Integer repositoryId, RepoDepFilterDTO filter) {
        int pageSize = Integer.parseInt(config.getPageSize());
        Pair<List<RepositoryDependencyPO>, Integer> p=repositoryDataService.allDepAndFilter(repositoryId, filter, pageSize);
        List<RepoDepVO> vos = p.getFirst()
                .stream()
                .map(RepoDepVO::build)
                .collect(Collectors.toList());
        return new RepoDepListVO(filter.getPage(), pageSize, vos);
    }

}
