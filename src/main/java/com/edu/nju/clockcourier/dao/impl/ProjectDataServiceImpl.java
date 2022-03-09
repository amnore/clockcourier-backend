package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.constant.Convention;
import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dao.mapper.ProjDepMapper;
import com.edu.nju.clockcourier.dao.mapper.ProjectMapper;
import com.edu.nju.clockcourier.dao.support.ProjDepDSS;
import com.edu.nju.clockcourier.dao.support.ProjectDSS;
import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectDependencyPO;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.util.QueryBuilder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

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
    public Pair<List<ProjectPO>, Integer> allAndFilter(ProjFilterDTO filter, int pageSize) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder select = SqlBuilder.select(ProjectMapper.selectList)
                .from(ProjectDSS.PROJECTS)
                .where(ProjectDSS.projectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getName())))
                .and(ProjectDSS.platform, isLikeWhenPresent(QueryBuilder.buildLike(filter.getPlatform())))
                .and(ProjectDSS.language, isEqualToWhenPresent(filter.getLanguage()))
                .and(ProjectDSS.homepageUrl, isLikeWhenPresent(QueryBuilder.buildLike(filter.getHomepageUrl())))
                .and(ProjectDSS.latestReleaseNumber, isLikeWhenPresent(QueryBuilder.buildLike(filter.getLatestReleaseN())));
        if (!Convention.isNull(filter.getDependency())) {
            select = select.and(ProjectDSS.projectId, isIn(
                    SqlBuilder.select(ProjDepDSS.projectId)
                            .from(ProjDepDSS.PROJECT_DEPENDENCIES)
                            .where(ProjDepDSS.dependencyProjectName, isLike(QueryBuilder.buildLike(filter.getDependency()))))
            );
        }
        Integer pageNum = filter.getPage();
        if (pageNum == null) pageNum = 1;
        SelectStatementProvider selector = select
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectPO> all = projectMapper.selectMany(selector);
        PageInfo<ProjectPO> pi = new PageInfo<>(all);
        return Pair.of(all, pi.getPages());
    }

    @Override
    public Pair<List<ProjectDependencyPO>, Integer> allDepAndFilter(Integer projectId, ProjDepFilterDTO filter, int pageSize) {
        SelectStatementProvider select = SqlBuilder
                .select(ProjDepMapper.selectList)
                .from(ProjDepDSS.PROJECT_DEPENDENCIES)
                .where(ProjDepDSS.projectId, isEqualTo(projectId))
                .and(ProjDepDSS.projectVersion, isLikeWhenPresent(QueryBuilder.buildLike(filter.getProjectVersion())))
                .and(ProjDepDSS.dependencyProjectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependencyProjectName())))
                .and(ProjDepDSS.dependencyProjectPlatform, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependencyProjectPlatform())))
                .and(ProjDepDSS.dependencyType, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependencyType())))
                .orderBy(QueryBuilder.buildReverse(ProjDepDSS.dependencyProjectName, filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Integer pageNum = filter.getPage();
        if (pageNum == null) pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);

        PageInfo<ProjectDependencyPO> pi = new PageInfo<>(projDepMapper.selectMany(select));
        return Pair.of(pi.getList(), pi.getPages());
    }

}
