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
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<RepositoryPO> allAndFilter(RepoFilterDTO filter, int pageSize) {

        Integer pageNum = filter.getPage();
        if (pageNum != null) PageHelper.startPage(pageNum, pageSize);
        Integer fork=null;
        if(filter.getCanFork()!=null) fork=filter.getCanFork() ?1:0;
        SelectStatementProvider select = SqlBuilder.selectDistinct(RepositoryMapper.selectList)
                .from(RepositoryDSS.REPOSITORIES)
                .join(RepoDepDSS.REPOSITORY_DEPENDENCIES)
                .on(RepositoryDSS.repositoryId, equalTo(RepoDepDSS.repositoryId))
                .where(RepositoryDSS.hostType,isLikeWhenPresent(QueryBuilder.buildLike(filter.getHostType())))
                .and(RepositoryDSS.repositoryName,isLikeWhenPresent(QueryBuilder.buildLike(filter.getRepositoryName())))
                .and(RepositoryDSS.repositoryOwner,isLikeWhenPresent(QueryBuilder.buildLike(filter.getRepositoryOwner())))
                .and(RepositoryDSS.language,isLikeWhenPresent(QueryBuilder.buildLike(filter.getLanguage())))
                .and(RepositoryDSS.homepageUrl,isLikeWhenPresent(QueryBuilder.buildLike(filter.getHomepageUrl())))
                .and(RepositoryDSS.fork,isEqualToWhenPresent(fork))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return repositoryMapper.selectMany(select);
    }

    @Override
    public List<RepositoryDependencyPO> allDepAndFilter(Integer repositoryId, RepoDepFilterDTO filter, int pageSize) {
        Integer pageNum = filter.getPage();
        if (pageNum != null) PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider select = SqlBuilder.selectDistinct(RepoDepMapper.selectList)
                .from(RepoDepDSS.REPOSITORY_DEPENDENCIES)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return repoDepMapper.selectMany(select);
    }

}
