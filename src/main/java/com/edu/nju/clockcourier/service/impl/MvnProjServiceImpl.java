package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.dao.MvnProjDataService;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import com.edu.nju.clockcourier.service.MvnProjService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MvnProjServiceImpl implements MvnProjService {

    private final MvnProjDataService mvnProjDataService;
    private final DatabaseConfig config;

    public MvnProjServiceImpl(MvnProjDataService mvnProjDataService, DatabaseConfig databaseConfig) {
        this.mvnProjDataService = mvnProjDataService;
        this.config = databaseConfig;
    }

    @Override
    public MvnProjListVO query(MvnProjFilterDTO filter) {
        //每页大小
        int pageSize = Integer.parseInt(config.getPageSize());
        //获取所有maven项目的projectId
        Pair<List<MvnProjectPO>, Integer> p = mvnProjDataService.allAndFilter(filter, pageSize);

        List<MvnProjectPO> mvnProjectPOS = p.getFirst();
        List<MvnProjVO> mvnProjVOS = new ArrayList<>();

        //获取每个maven项目的最新版本信息
        for (MvnProjectPO mvnProjectPO : mvnProjectPOS) {
            List<MvnProjectPO> mvnProjectPOS1 = mvnProjDataService.getNewMvnProj(mvnProjectPO.getProjectId());
            MvnProjectPO newMvnProj = mvnProjectPOS1.get(0);
            List<String> versions = new ArrayList<>();
            for (MvnProjectPO mvnProjectPO1 : mvnProjectPOS1) {
                versions.add(mvnProjectPO1.getVersion());
            }
            mvnProjVOS.add(new MvnProjVO(newMvnProj.getProjectId()
                    , newMvnProj.getName()
                    , newMvnProj.getGroupId()
                    , newMvnProj.getArtifactId()
                    , versions
                    , newMvnProj.getDescription()
                    , newMvnProj.getUrl()));
        }
        //返回结果
        return new MvnProjListVO(p.getSecond(), pageSize, mvnProjVOS);
    }

    @Override
    public MvnProjVersionVO getMvn(Integer projectId, String version) {

        //找到该版本的PO
        MvnProjectPO mvnProjectPO = mvnProjDataService.getMvnProjVersion(projectId, version);

        //如果没找到，返回空
        if (MvnProjectPO.isNullInstance(mvnProjectPO)) {
            return new MvnProjVersionVO();
        }

        //寻找对应依赖
        List<MvnDependencyPO> mvnDependencyPOS = mvnProjDataService.getMvnDep(projectId, version);

        List<MvnProjDepVO> mvnProjDepVOS = new ArrayList<>();

        //根据libId去寻找对应依赖
        for (MvnDependencyPO mvnDependencyPO : mvnDependencyPOS) {
            String depVersion = mvnDependencyPO.getLibVersion();
            Integer depId = mvnDependencyPO.getLibId();
            MvnLibPO mvnLibPO = mvnProjDataService.getLibByPrimaryKey(depId);
            mvnProjDepVOS.add(new MvnProjDepVO(depId
                    , mvnLibPO.getGroupId()
                    , mvnLibPO.getArtifactId()
                    , depVersion));
        }

        return new MvnProjVersionVO(mvnProjectPO.getProjectId()
                , mvnProjectPO.getName()
                , mvnProjectPO.getGroupId()
                , mvnProjectPO.getArtifactId()
                , mvnProjectPO.getVersion()
                , mvnProjDepVOS);
    }

    @Override
    public MigrationRuleVO getGraph(Integer libId) {
        //新建VO
        MigrationRuleVO migrationRuleVO = new MigrationRuleVO();
        //设置libVO
        MvnLibPO mvnLibPO = mvnProjDataService.getLibByPrimaryKey(libId);
        MvnLibVO mvnLibVO = MvnLibVO.build(mvnLibPO);
        migrationRuleVO.setMvnLibVO(mvnLibVO);

        //查找到达的节点
        List<MigrationRulePO> migrationRulePOS = mvnProjDataService.getRuleByFromId(libId);

        //到达节点数量
        migrationRuleVO.setNum(migrationRulePOS.size());

        //到达节点集合
        List<MigrationRuleVO> migrationRuleVOS = new ArrayList<>();

        //对于每个到达节点，递归加到结果集合中
        for (MigrationRulePO po : migrationRulePOS) {
            migrationRuleVOS.add(getGraph(po.getFromId()));
        }
        //设置以当前lib为起点的规则集合
        migrationRuleVO.setEdges(migrationRuleVOS);
        //返回结果
        return migrationRuleVO;
    }

    @Override
    public MvnProjVO getBase(Integer projectId) {
        //1.获取projectId对应的Maven项目
        List<MvnProjectPO> mvnProjectPOS = mvnProjDataService.getMvnProj(projectId);

        //如果没找到,返回空
        if (mvnProjectPOS.size() == 0) {
            //返回空VO
            return new MvnProjVO();
        }

        //2.获取所有的版本号
        List<String> versions = new ArrayList<>();
        for (MvnProjectPO mvnProjectPO : mvnProjectPOS) {
            versions.add(mvnProjectPO.getVersion());
        }
        MvnProjectPO p0 = mvnProjectPOS.get(0);

        //3.返回VO
        return new MvnProjVO(p0.getProjectId(),
                p0.getName(),
                p0.getGroupId(),
                p0.getArtifactId(),
                versions,
                p0.getDescription(),
                p0.getUrl());
    }

    @Override
    public MvnLibVO getLib(String groupId, String artifactId) {
        //通过groupId和artifactId查找相应lib并返回
        MvnLibPO mvnLibPO = mvnProjDataService.getLib(groupId, artifactId);
        return new MvnLibVO(mvnLibPO.getLibId(),
                mvnLibPO.getGroupId(),
                mvnLibPO.getArtifactId());
    }
}
