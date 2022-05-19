package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MvnLibraryDataService;
import com.edu.nju.clockcourier.dao.mapper.MvnLibMapper;
import com.edu.nju.clockcourier.dao.support.MvnLibDSS;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.util.QueryBuilder;
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
public class MvnLibraryDataServiceImpl implements MvnLibraryDataService {

    private final MvnLibMapper mvnLibMapper;

    @Autowired
    public MvnLibraryDataServiceImpl(MvnLibMapper mvnLibMapper) {
        this.mvnLibMapper = mvnLibMapper;
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
    public Pair<List<MvnLibPO>, Integer> allMvnLibAndFilter(MvnLibFilterDTO filter) {
        int size = filter.getEndIndex() - filter.getStartIndex();
        // 选择符合条件的 libraries
        SelectStatementProvider selector = SqlBuilder
                .select(MvnLibMapper.selectList)
                .from(MvnLibDSS.mvnLib)
                .where(MvnLibDSS.groupId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getGroupId())))
                .and(MvnLibDSS.artifactId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getArtifactId())))
                .orderBy(QueryBuilder.buildReverse(filter.getSort().getSortRule(), filter.getIsReverse()))
                .limit(size).offset(filter.getStartIndex())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<MvnLibPO> all = mvnLibMapper.selectMany(selector);
        // 计算总数
        SelectStatementProvider count = SqlBuilder
                .select(MvnLibMapper.selectList)
                .from(MvnLibDSS.mvnLib)
                .where(MvnLibDSS.groupId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getGroupId())))
                .and(MvnLibDSS.artifactId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getArtifactId())))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int allSize = mvnLibMapper.selectMany(count).size();
        return Pair.of(all, allSize);
    }

}
