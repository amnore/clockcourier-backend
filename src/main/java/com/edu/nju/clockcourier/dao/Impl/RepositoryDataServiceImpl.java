package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dao.mapper.RepositoryMapper;
import org.springframework.stereotype.Service;

@Service
public class RepositoryDataServiceImpl implements RepositoryDataService {

    private final RepositoryMapper repositoryMapper;

    public RepositoryDataServiceImpl(RepositoryMapper repositoryMapper){
        this.repositoryMapper=repositoryMapper;
    }
}
