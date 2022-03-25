package com.edu.nju.clockcourier.dao.impl;

import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.dao.mapper.MvnDependencyMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnLibMapper;
import com.edu.nju.clockcourier.dao.mapper.MvnProjectMapper;
import com.edu.nju.clockcourier.dao.support.MvnDepDSS;
import com.edu.nju.clockcourier.dao.support.MvnLibDSS;
import com.edu.nju.clockcourier.dao.support.MvnProjDSS;
import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class MvnDataServiceImpl implements MvnDataService {

    private final MvnDependencyMapper mvnDependencyMapper;
    private final MvnLibMapper mvnLibMapper;
    private final MvnProjectMapper mvnProjectMapper;

    @Autowired
    public MvnDataServiceImpl(MvnDependencyMapper mvnDependencyMapper,
                              MvnLibMapper mvnLibMapper,
                              MvnProjectMapper mvnProjectMapper) {
        this.mvnDependencyMapper = mvnDependencyMapper;
        this.mvnLibMapper = mvnLibMapper;
        this.mvnProjectMapper = mvnProjectMapper;
    }

    @Override
    public void insertLib(MvnLibPO po) {
        this.mvnLibMapper.insert(po);
    }

    @Override
    public MvnLibPO findLib(String groupId, String artifactId) {
        return this.mvnLibMapper.selectOne(cur -> cur
                        .where(MvnLibDSS.groupId, isEqualTo(groupId))
                        .and(MvnLibDSS.artifactId, isEqualTo(artifactId)))
                .orElse(MvnLibPO.getNullInstance());
    }

    @Override
    @Transactional
    public void insertMvnProjIfNotExists(MvnProjectPO po) {
        long c = this.mvnProjectMapper.count(cur -> cur
                .where(MvnProjDSS.projectId, isEqualTo(po.getProjectId()))
                .and(MvnProjDSS.version, isEqualTo(po.getVersion()))
        );
        if (c != 0L) return;
        // 如果自增列不是 null, 那么 insert 后会被复写为一个不知道哪里来的值
        this.mvnProjectMapper.insert(po);
    }

    @Override
    public Integer getMvnProjIdIfExists(String groupId, String artifactId) {
        List<MvnProjectPO> pos = this.mvnProjectMapper.select(cur -> cur
                .where(MvnProjDSS.groupId, isEqualTo(groupId))
                .and(MvnProjDSS.artifactId, isEqualTo(artifactId)));
        if (pos.size() == 0) return null;
        return pos.get(0).getProjectId();
    }

    @Override
    public List<MvnProjectPO> allMvnProjWithMultiVersions() {
        SelectStatementProvider provider = SqlBuilder
                .select(MvnProjectMapper.selectList)
                .from(MvnProjDSS.mvnProject, "t1")
                .where(exists(select(MvnProjectMapper.selectList)
                        .from(MvnProjDSS.mvnProject, "t2")
                        .where(MvnProjDSS.projectId.qualifiedWith("t1"), isEqualTo(MvnProjDSS.projectId.qualifiedWith("t2")))
                        .and(MvnProjDSS.version.qualifiedWith("t1"), isNotEqualTo(MvnProjDSS.version.qualifiedWith("t2")))
                ))
                .orderBy(MvnProjDSS.projectId, MvnProjDSS.version)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return this.mvnProjectMapper.selectMany(provider);
    }

    @Override
    public void insertMvnDepIfNotExists(MvnDependencyPO po) {
        long c = this.mvnDependencyMapper.count(cur -> cur
                .where(MvnDepDSS.projectId, isEqualTo(po.getProjectId()))
                .and(MvnDepDSS.version, isEqualTo(po.getVersion()))
                .and(MvnDepDSS.libId, isEqualTo(po.getLibId()))
        );
        if (c != 0L) return;
        this.mvnDependencyMapper.insert(po);
    }

    @Override
    public List<MvnDependencyPO> allMvnDep(Integer projectId, String version) {
        return this.mvnDependencyMapper.select(cur -> cur
                .where(MvnDepDSS.projectId, isEqualTo(projectId))
                .and(MvnDepDSS.version, isEqualTo(version)));
    }

}
