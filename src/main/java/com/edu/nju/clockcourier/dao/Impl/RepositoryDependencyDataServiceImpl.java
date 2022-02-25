package com.edu.nju.clockcourier.dao.Impl;

import com.edu.nju.clockcourier.dao.mapper.RepositoryDependencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryDependencyDataServiceImpl {

    private final RepositoryDependencyMapper repositoryDependencyMapper;

    @Autowired
    public RepositoryDependencyDataServiceImpl(RepositoryDependencyMapper repositoryDependencyMapper){
        this.repositoryDependencyMapper=repositoryDependencyMapper;
    }
}
