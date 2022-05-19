package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MvnProjectDataService;
import com.edu.nju.clockcourier.dao.mapper.MvnProjectMapper;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MvnProjectDataServiceImpl implements MvnProjectDataService {

    private final MvnProjectMapper mvnProjectMapper;

    @Autowired
    public MvnProjectDataServiceImpl(MvnProjectMapper mapper) {
        this.mvnProjectMapper = mapper;
    }

    @Override
    public MvnProjectPO getProject(Integer id) {
        return this.mvnProjectMapper.selectByPrimaryKey(id)
                .orElse(MvnProjectPO.getNullInstance());
    }

}
