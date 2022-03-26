package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.dao.mapper.MvnDepMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnLibMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnProjMapper;
import com.edu.nju.clockcourier.dao.support.MvnDepDSS;
import com.edu.nju.clockcourier.dao.support.MvnLibDSS;
import com.edu.nju.clockcourier.dao.support.MvnProjDSS;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
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
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class MvnDataServiceImpl implements MvnDataService {

    private final MvnDepMapper mvnDepMapper;
    private final MvnLibMapper mvnLibMapper;
    private final MvnProjMapper mvnProjMapper;

    @Autowired
    public MvnDataServiceImpl(MvnDepMapper mvnDepMapper,
                              MvnLibMapper mvnLibMapper,
                              MvnProjMapper mvnProjMapper) {
        this.mvnDepMapper = mvnDepMapper;
        this.mvnLibMapper = mvnLibMapper;
        this.mvnProjMapper = mvnProjMapper;
    }

    @Override
    public void insertMvnLib(MvnLibPO po) {
        this.mvnLibMapper.insert(po);
    }

    @Override
    public MvnLibPO getMvnLib(String groupId, String artifactId) {
        return this.mvnLibMapper.selectOne(cur -> cur
                .where(MvnLibDSS.groupId, isEqualTo(groupId))
                .and(MvnLibDSS.artifactId, isEqualTo(artifactId)))
                .orElse(MvnLibPO.getNullInstance());
    }

    @Override
    public MvnLibPO getMvnLib(Integer libId) {
        return this.mvnLibMapper.selectByPrimaryKey(libId)
                .orElse(MvnLibPO.getNullInstance());
    }

    @Override
    public void insertMvnProjIfNotExists(MvnProjPO po) {
        long c = this.mvnProjMapper.count(cur -> cur
                .where(MvnProjDSS.projectId, isEqualTo(po.getProjectId()))
                .and(MvnProjDSS.version, isEqualTo(po.getVersion()))
        );
        if (c != 0L) return;
        // 如果自增列不是 null, 那么 insert 后会被复写为一个不知道哪里来的值
        this.mvnProjMapper.insert(po);
    }

    @Override
    public Integer getMvnProjIdIfExists(String groupId, String artifactId) {
        List<MvnProjPO> pos = this.mvnProjMapper.select(cur -> cur
                .where(MvnProjDSS.groupId, isEqualTo(groupId))
                .and(MvnProjDSS.artifactId, isEqualTo(artifactId)));
        if (pos.size() == 0) return null;
        return pos.get(0).getProjectId();
    }

    @Override
    public MvnProjPO getMvnProj(Integer projectId, String version) {
        SelectStatementProvider selector = SqlBuilder
                .selectDistinct(MvnProjMapper.selectList)
                .from(MvnProjDSS.mvnProject)
                .where(MvnProjDSS.projectId, isEqualTo(projectId))
                .and(MvnProjDSS.version, isEqualTo(version))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.mvnProjMapper.selectOne(selector)
                .orElse(MvnProjPO.getNullInstance());
    }

    @Override
    public MvnProjPO getNewestMvnProj(Integer projectId) {
        SelectStatementProvider select = SqlBuilder
                .select(MvnProjMapper.selectList)
                .from(MvnProjDSS.mvnProject)
                .where(MvnProjDSS.projectId, isEqualTo(projectId))
                .and(MvnProjDSS.version, isEqualTo(select(max(MvnProjDSS.version))
                        .from(MvnProjDSS.mvnProject)
                        .where(MvnProjDSS.projectId, isEqualTo(projectId))))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.mvnProjMapper.selectOne(select)
                .orElse(MvnProjPO.getNullInstance());
    }

    @Override
    public List<MvnProjPO> allMvnProjWithMultiVersions() {
        SelectStatementProvider provider = SqlBuilder
                .select(MvnProjMapper.selectList)
                .from(MvnProjDSS.mvnProject, "t1")
                .where(exists(select(MvnProjMapper.selectList)
                        .from(MvnProjDSS.mvnProject, "t2")
                        .where(MvnProjDSS.projectId.qualifiedWith("t1"), isEqualTo(MvnProjDSS.projectId.qualifiedWith("t2")))
                        .and(MvnProjDSS.version.qualifiedWith("t1"), isNotEqualTo(MvnProjDSS.version.qualifiedWith("t2")))
                ))
                .orderBy(MvnProjDSS.projectId, MvnProjDSS.version)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.mvnProjMapper.selectMany(provider);
    }

    @Override
    public Pair<List<MvnProjPO>, Integer> allMvnProjAndFilterNewest(MvnProjFilterDTO filter, int pageSize) {
        SelectStatementProvider selector = SqlBuilder
                .select(MvnProjMapper.selectList)
                .from(MvnProjDSS.mvnProject, "t1")
                .where(MvnProjDSS.groupId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getGroupId())))
                .and(MvnProjDSS.artifactId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getArtifactId())))
                .and(MvnProjDSS.version, isEqualTo(select(max(MvnProjDSS.version))
                        .from(MvnProjDSS.mvnProject, "t2")
                        .where(MvnProjDSS.projectId.qualifiedWith("t1"), isEqualTo(MvnProjDSS.projectId.qualifiedWith("t2")))))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Integer pageNum = filter.getStartIndex();
        int pages = filter.getEndIndex() - filter.getStartIndex();
        if (pageNum == null) pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);
        List<MvnProjPO> all = mvnProjMapper.selectMany(selector);
        PageInfo<MvnProjPO> pi = new PageInfo<>(all, pages);
        return Pair.of(all, pi.getPages());
    }

    @Override
    public Pair<List<MvnLibPO>, Integer> allMvnLibAndFilter(MvnLibFilterDTO filter, int pageSize) {
        SelectStatementProvider selector = SqlBuilder
                .select(MvnLibMapper.selectList)
                .from(MvnLibDSS.mvnLib)
                .where(MvnLibDSS.groupId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getGroupId())))
                .and(MvnLibDSS.artifactId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getArtifactId())))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Integer pageNum = filter.getStartIndex();
        int pages = filter.getEndIndex() - filter.getStartIndex();
        if (pageNum == null) pageNum = 1;
        PageHelper.startPage(pageNum, pageSize);
        List<MvnLibPO> all = mvnLibMapper.selectMany(selector);
        PageInfo<MvnLibPO> pi = new PageInfo<>(all, pages);
        return Pair.of(all, pi.getPages());
    }

    @Override
    public List<String> allMvnProjVersions(Integer projectId) {
        SelectStatementProvider select = SqlBuilder
                .select(MvnProjDSS.version)
                .from(MvnProjDSS.mvnProject)
                .where(MvnProjDSS.projectId, isEqualTo(projectId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.mvnProjMapper.selectMany(select)
                .stream()
                .map(MvnProjPO::getVersion)
                .collect(Collectors.toList());
    }

    @Override
    public void insertMvnDepIfNotExists(MvnDepPO po) {
        long c = this.mvnDepMapper.count(cur -> cur
                .where(MvnDepDSS.projectId, isEqualTo(po.getProjectId()))
                .and(MvnDepDSS.version, isEqualTo(po.getVersion()))
                .and(MvnDepDSS.libId, isEqualTo(po.getLibId()))
        );
        if (c != 0L) return;
        this.mvnDepMapper.insert(po);
    }

    @Override
    public List<MvnDepPO> allMvnDeps(Integer projectId, String version) {
        return this.mvnDepMapper.select(cur -> cur
                .where(MvnDepDSS.projectId, isEqualTo(projectId))
                .and(MvnDepDSS.version, isEqualTo(version)));
    }

}
