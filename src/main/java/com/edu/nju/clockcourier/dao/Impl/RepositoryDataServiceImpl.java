package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.mapper.RepositoryMapper;

public class RepositoryDataServiceImpl {

    private final RepositoryMapper repositoryMapper;

    public RepositoryDataServiceImpl(RepositoryMapper repositoryMapper){
        this.repositoryMapper=repositoryMapper;
    }
}
