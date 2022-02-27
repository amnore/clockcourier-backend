package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dao.mapper.ProjDepMapper;
import com.edu.nju.clockcourier.dao.mapper.ProjectMapper;
import com.edu.nju.clockcourier.dao.support.ProjDepDSS;
import com.edu.nju.clockcourier.dao.support.ProjectDSS;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.util.QueryBuilder;
import com.github.pagehelper.PageHelper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;

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
        SelectStatementProvider select = SqlBuilder.selectDistinct(ProjectMapper.selectList)
                .from(ProjectDSS.PROJECTS)
                .join(ProjDepDSS.PROJECT_DEPENDENCIES)
                .on(ProjectDSS.projectId, equalTo(ProjDepDSS.projectId))
                .where(ProjDepDSS.dependencyProjectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependency())))
                .where(ProjectDSS.projectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getName())))
                .and(ProjectDSS.platform, isLikeWhenPresent(QueryBuilder.buildLike(filter.getPlatform())))
                .and(ProjectDSS.language, isLikeWhenPresent(QueryBuilder.buildLike(filter.getLanguage())))
                .and(ProjectDSS.homepageUrl, isLikeWhenPresent(QueryBuilder.buildLike(filter.getHomepageUrl())))
                .and(ProjectDSS.latestReleaseNumber, isLikeWhenPresent(QueryBuilder.buildLike(filter.getLatestReleaseN())))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return projectMapper.selectMany(select);
    }

}