package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dao.mapper.ProjDepMapper;
import com.edu.nju.clockcourier.dao.mapper.ProjectMapper;
import com.edu.nju.clockcourier.dao.support.ProjectDSS;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

@Service
public class ProjectDataServiceImpl implements ProjectDataService {

    private final ProjectMapper projectMapper;
    private final ProjDepMapper projDepMapper;

    @Autowired
    public ProjectDataServiceImpl(ProjectMapper projectMapper,
                                  ProjDepMapper projDepMapper) {
        this.projectMapper = projectMapper;
        this.projDepMapper = projDepMapper;
    }

    @Override
    public ProjectPO getProject(Integer id) {
        return projectMapper
                .selectByPrimaryKey(id)
                .orElse(ProjectPO.getNullInstance());
    }

    @Override
    public List<ProjectPO> allAndFilter(ProjFilterDTO filter, int pageSize) {
        // 开启分页
        Integer pageNum = filter.getPage();
        if (pageNum != null) PageHelper.startPage(pageNum, pageSize);
        return projectMapper.select(
                c -> c
                        .where(ProjectDSS.projectName, isEqualToWhenPresent(filter.getName()))
                        .where(ProjectDSS.platform, isEqualToWhenPresent(filter.getPlatform()))
                        .where(ProjectDSS.language, isEqualToWhenPresent(filter.getLanguage()))
        );
    }

}
