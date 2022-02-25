package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryDataService repositoryDataService;

    @Autowired
    public RepositoryServiceImpl (RepositoryDataService repositoryDataService){
        this.repositoryDataService=repositoryDataService;
    }

}
