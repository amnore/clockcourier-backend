package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MvnProjDataService;
import com.edu.nju.clockcourier.dao.mapper.MigrationRuleMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnDependencyMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnLibMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnProjectMapper;
import com.edu.nju.clockcourier.dao.support.MigrationRuleDSS;
import com.edu.nju.clockcourier.dao.support.MvnDependencyDSS;
import com.edu.nju.clockcourier.dao.support.MvnLibDSS;
import com.edu.nju.clockcourier.dao.support.MvnProjectDSS;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
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

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;

@Service
public class MvnProjDataServiceImpl implements MvnProjDataService {
    private final MigrationRuleMapper migrationRuleMapper;

    private final MvnDependencyMapper mvnDependencyMapper;

    private final MvnLibMapper mvnLibMapper;

    private final MvnProjectMapper mvnProjectMapper;


    @Autowired
    public MvnProjDataServiceImpl(MigrationRuleMapper migrationRuleMapper,
                                  MvnDependencyMapper mvnDependencyMapper,
                                  MvnLibMapper mvnLibMapper,
                                  MvnProjectMapper mvnProjectMapper) {
        this.migrationRuleMapper = migrationRuleMapper;
        this.mvnDependencyMapper = mvnDependencyMapper;
        this.mvnLibMapper = mvnLibMapper;
        this.mvnProjectMapper = mvnProjectMapper;
    }

    //获取指定项目的指定版本
    @Override
    public MvnProjectPO getMvnProjVersion(Integer projectId, String version) {
        SelectStatementProvider selector = SqlBuilder.selectDistinct(MvnProjectMapper.selectList)
                .from(MvnProjectDSS.mvnProject)
                .where(MvnProjectDSS.projectId, isEqualTo(projectId))
                .and(MvnProjectDSS.version, isEqualTo(version))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return mvnProjectMapper.selectOne(selector).orElse(MvnProjectPO.getNullInstance());
    }

    //获取指定项目的最新版本
    @Override
    public List<MvnProjectPO> getNewMvnProj(Integer projectId) {
        SelectStatementProvider selector = SqlBuilder.select(MvnProjectMapper.selectList)
                .from(MvnProjectDSS.mvnProject)
                .where(MvnProjectDSS.projectId, isEqualTo(projectId))
                .orderBy(MvnProjectDSS.version.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<MvnProjectPO> mvnProjectPOS = mvnProjectMapper.selectMany(selector);
        return mvnProjectPOS;
    }

    //获取指定项目的指定版本的所有依赖信息
    @Override
    public List<MvnDependencyPO> getMvnDep(Integer projectId, String version) {
        SelectStatementProvider selector = SqlBuilder.select(MvnDependencyMapper.selectList)
                .from(MvnDependencyDSS.mvnDependency)
                .where(MvnDependencyDSS.projectId, isEqualTo(projectId))
                .and(MvnDependencyDSS.version, isEqualTo(version))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return mvnDependencyMapper.selectMany(selector);
    }

    //获取指定项目的所有版本
    @Override
    public List<MvnProjectPO> getMvnProj(Integer projectId) {
        SelectStatementProvider selector = SqlBuilder.select(MvnProjectMapper.selectList)
                .from(MvnProjectDSS.mvnProject)
                .where(MvnProjectDSS.projectId, isEqualTo(projectId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return mvnProjectMapper.selectMany(selector);
    }

    //通过主键获取指定lib
    @Override
    public MvnLibPO getLibByPrimaryKey(Integer libId) {
        SelectStatementProvider selector = SqlBuilder.select(MvnLibMapper.selectList)
                .from(MvnLibDSS.mvnLib)
                .where(MvnLibDSS.libId, isEqualTo(libId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return mvnLibMapper.selectByPrimaryKey(libId).orElse(MvnLibPO.getNullInstance());
    }

    //通过groupId和artifactId获取指定lib
    @Override
    public MvnLibPO getLib(String groupId, String artifactId) {
        SelectStatementProvider selector = SqlBuilder.select(MvnLibMapper.selectList)
                .from(MvnLibDSS.mvnLib)
                .where(MvnLibDSS.groupId, isEqualTo(groupId))
                .and(MvnLibDSS.artifactId, isEqualTo(artifactId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return mvnLibMapper.selectOne(selector).orElse(MvnLibPO.getNullInstance());
    }

    //获取以libId为起点的规则
    @Override
    public List<MigrationRulePO> getRuleByFromId(Integer libId) {
        SelectStatementProvider selector = SqlBuilder.select(MigrationRuleMapper.selectList)
                .from(MigrationRuleDSS.migrationRule)
                .where(MigrationRuleDSS.fromId, isEqualTo(libId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return migrationRuleMapper.selectMany(selector);
    }

    //获取以libId为终点的规则
    @Override
    public List<MigrationRulePO> getRuleByToId(Integer libId) {
        SelectStatementProvider selector = SqlBuilder.select(MigrationRuleMapper.selectList)
                .from(MigrationRuleDSS.migrationRule)
                .where(MigrationRuleDSS.toId, isEqualTo(libId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return migrationRuleMapper.selectMany(selector);
    }

    //获取以fromId为起点，toId为终点的规则
    @Override
    public MigrationRulePO getRule(Integer fromId, Integer toId) {
        SelectStatementProvider selector = SqlBuilder.select(MigrationRuleMapper.selectList)
                .from(MigrationRuleDSS.migrationRule)
                .where(MigrationRuleDSS.fromId, isEqualTo(fromId))
                .and(MigrationRuleDSS.toId, isEqualTo(toId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return migrationRuleMapper.selectOne(selector).orElse(new MigrationRulePO());
    }

    //获取满足搜索条件的所有maven项目
    @Override
    public Pair<List<MvnProjectPO>, Integer> allAndFilter(MvnProjFilterDTO filter, int pageSize) {
        SelectStatementProvider selector = SqlBuilder
                .selectDistinct(MvnProjectDSS.projectId, MvnProjectDSS.artifactId)
                .from(MvnProjectDSS.mvnProject)
                .where(MvnProjectDSS.groupId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getGroupId())))
                .and(MvnProjectDSS.artifactId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getArtifactId())))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        Integer pageNum = filter.getStartIndex();

        int pages = filter.getEndIndex() - filter.getStartIndex();

        if (pageNum == null) pageNum = 1;

        PageHelper.startPage(pageNum, pageSize);
        List<MvnProjectPO> all = mvnProjectMapper.selectMany(selector);
        PageInfo<MvnProjectPO> pi = new PageInfo<>(all, pages);
        return Pair.of(all, pi.getPages());
    }
}
