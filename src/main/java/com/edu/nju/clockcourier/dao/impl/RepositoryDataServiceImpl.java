package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dao.mapper.RepoDepMapper;
import com.edu.nju.clockcourier.dao.mapper.RepositoryMapper;
import com.edu.nju.clockcourier.dao.support.RepoDepDSS;
import com.edu.nju.clockcourier.dao.support.RepositoryDSS;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import com.edu.nju.clockcourier.util.QueryBuilder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class RepositoryDataServiceImpl implements RepositoryDataService {

    private final RepositoryMapper repositoryMapper;
    private final RepoDepMapper repoDepMapper;

    @Autowired
    public RepositoryDataServiceImpl(RepositoryMapper repositoryMapper, RepoDepMapper repoDepMapper) {
        this.repositoryMapper = repositoryMapper;
        this.repoDepMapper = repoDepMapper;
    }

    @Override
    public RepositoryPO getRepository(Integer id) {
        return repositoryMapper
                .selectByPrimaryKey(id)
                .orElse(RepositoryPO.getNullInstance());
    }

    @Override
    public Pair<List<RepositoryPO>, Integer> allAndFilter(RepoFilterDTO filter, int pageSize) {
        SelectStatementProvider select = SqlBuilder
                .select(RepositoryMapper.selectList)
                .from(RepositoryDSS.REPOSITORIES)
                .where(RepositoryDSS.hostType, isLikeWhenPresent(QueryBuilder.buildLike(filter.getHostType())))
                .and(RepositoryDSS.repositoryName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getRepositoryName())))
                .and(RepositoryDSS.repositoryOwner, isLikeWhenPresent(QueryBuilder.buildLike(filter.getRepositoryOwner())))
                .and(RepositoryDSS.language, isLikeWhenPresent(QueryBuilder.buildLike(filter.getLanguage())))
                .and(RepositoryDSS.homepageUrl, isLikeWhenPresent(QueryBuilder.buildLike(filter.getHomepageUrl())))
                .and(RepositoryDSS.fork, isEqualToWhenPresent(QueryBuilder.buildBool(filter.getCanFork())))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Integer pageNum = filter.getPage();
        if (pageNum == null) pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);

        PageInfo<RepositoryPO> pi = new PageInfo<>(repositoryMapper.selectMany(select));
        return Pair.of(pi.getList(), pi.getPages());
    }

    @Override
    public Pair<List<RepositoryDependencyPO>, Integer> allDepAndFilter(Integer repositoryId, RepoDepFilterDTO filter, int pageSize) {
        SelectStatementProvider select = SqlBuilder
                .select(RepoDepMapper.selectList)
                .from(RepoDepDSS.REPOSITORY_DEPENDENCIES)
                .where(RepoDepDSS.repositoryId, isEqualTo(repositoryId))
                .and(RepoDepDSS.dependencyProjectName, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependencyProjectName())))
                .and(RepoDepDSS.dependencyType, isLikeWhenPresent(QueryBuilder.buildLike(filter.getDependencyType())))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Integer pageNum = filter.getPage();
        if (pageNum == null) pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<RepositoryDependencyPO> pi = new PageInfo<>(repoDepMapper.selectMany(select));
        return Pair.of(pi.getList(), pi.getPages());
    }

}
