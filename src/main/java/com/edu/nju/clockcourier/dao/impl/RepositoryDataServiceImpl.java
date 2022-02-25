package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dao.mapper.RepositoryMapper;
import com.edu.nju.clockcourier.po.RepositoryPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryDataServiceImpl implements RepositoryDataService {

    private final RepositoryMapper repositoryMapper;

    @Autowired
    public RepositoryDataServiceImpl(RepositoryMapper repositoryMapper) {
        this.repositoryMapper = repositoryMapper;
    }

    @Override
    public RepositoryPO getRepository(Integer id) {
        return repositoryMapper
                .selectByPrimaryKey(id)
                .orElse(RepositoryPO.getNullInstance());
    }

}
