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

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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

        System.err.printf("allMvnLibAndFilter: begin %s\n", Instant.now());
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

        System.err.printf("allMvnLibAndFilter: count %s\n", Instant.now());
        // 计算总数
        SelectStatementProvider count = SqlBuilder
                .countFrom(MvnLibDSS.mvnLib)
                .where(MvnLibDSS.groupId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getGroupId())))
                .and(MvnLibDSS.artifactId, isLikeWhenPresent(QueryBuilder.buildLike(filter.getArtifactId())))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int allSize = (int) mvnLibMapper.count(count);

        System.err.printf("allMvnLibAndFilter: end %s\n", Instant.now());
        return Pair.of(all, allSize);
    }

    @Override
    public List<Integer> allMvnLibId() {
        SelectStatementProvider selector = SqlBuilder
                .select(MvnLibDSS.libId)
                .from(MvnLibDSS.mvnLib)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.mvnLibMapper.selectMany(selector)
                .stream().map(MvnLibPO::getLibId)
                .collect(Collectors.toList());
    }

    @Override
    public void updateStartRuleNum(Integer libId, Integer num) {
        this.mvnLibMapper.update(c -> c.set(MvnLibDSS.startRuleNum)
                .equalTo(num)
                .where(MvnLibDSS.libId, isEqualTo(libId)));
    }

}
