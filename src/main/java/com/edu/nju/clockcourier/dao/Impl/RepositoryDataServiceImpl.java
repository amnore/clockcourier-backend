package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dao.mapper.RepositoryMapper;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepositoryDataServiceImpl implements RepositoryDataService {

    private final RepositoryMapper repositoryMapper;

    public RepositoryDataServiceImpl(RepositoryMapper repositoryMapper){
        this.repositoryMapper=repositoryMapper;
    }

    @Override
    public RepositoryPO getRepository(Integer id) {
        Optional<RepositoryPO> repository=repositoryMapper.selectByPrimaryKey(id);
        return repository.orElse(null);
    }
}
