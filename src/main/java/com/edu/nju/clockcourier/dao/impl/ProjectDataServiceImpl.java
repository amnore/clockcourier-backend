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
    public PageInfo<ProjectPO> allAndFilter(ProjFilterDTO filter, int pageSize) {
        // 开启分页, 它会在 sql 语句中插入, 所以几乎没有额外性能消耗
        Integer pageNum = filter.getPage();
        if (pageNum != null) PageHelper.startPage(pageNum, pageSize);
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder select =
                SqlBuilder
                        .selectDistinct(ProjectMapper.selectList)
                        .from(ProjectDSS.PROJECTS)
                        .where(ProjDepDSS.dependencyProjectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependency())))
                        .and(ProjectDSS.projectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getName())))
                        .and(ProjectDSS.platform, isLikeWhenPresent(QueryBuilder.buildLike(filter.getPlatform())))
                        .and(ProjectDSS.language, isLikeWhenPresent(QueryBuilder.buildLike(filter.getLanguage())))
                        .and(ProjectDSS.homepageUrl, isLikeWhenPresent(QueryBuilder.buildLike(filter.getHomepageUrl())))
                        .and(ProjectDSS.latestReleaseNumber, isLikeWhenPresent(QueryBuilder.buildLike(filter.getLatestReleaseN())));
        if (!filter.getDependency().equals(Convention.nullStr)) {
            select = select
                    .and(ProjectDSS.projectId, isIn(
                            SqlBuilder.selectDistinct(ProjDepDSS.projectId)
                                    .from(ProjDepDSS.PROJECT_DEPENDENCIES)
                                    .where(ProjDepDSS.dependencyProjectName, isLike(filter.getDependency())))
                    );
        }
        SelectStatementProvider selector = select
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return new PageInfo<>(projectMapper.selectMany(selector));
    }

    @Override
    public List<ProjectDependencyPO> allDepAndFilter(Integer projectId, ProjDepFilterDTO filter, int pageSize) {
        Integer pageNum = filter.getPage();
        if (pageNum != null) PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider select = SqlBuilder.selectDistinct(ProjDepMapper.selectList)
                .from(ProjDepDSS.PROJECT_DEPENDENCIES)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return projDepMapper.selectMany(select);
    }

}
