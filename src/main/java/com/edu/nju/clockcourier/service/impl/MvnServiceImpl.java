package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MvnServiceImpl implements MvnService {

    private final MvnDataService mvnDataService;
    private final DatabaseConfig config;

    public MvnServiceImpl(MvnDataService mvnDataService,
                          DatabaseConfig databaseConfig) {
        this.mvnDataService = mvnDataService;
        this.config = databaseConfig;
    }

    @Override
    public MvnProjListVO getMvnProjects(MvnProjFilterDTO filter) {
        Pair<List<MvnProjPO>, Integer> p = this.mvnDataService
                .allMvnProjAndFilterNewest(filter);
        List<MvnProjPO> mvnProjects = p.getFirst();
        List<MvnNewestProjVO> res = new ArrayList<>();
        mvnProjects.forEach(cur -> {
            List<String> versions = this.mvnDataService.allMvnProjVersions(cur.getProjectId());
            res.add(MvnNewestProjVO.build(cur, versions));
        });
        return new MvnProjListVO(p.getSecond(), res);
    }

    @Override
    public MvnLibListVO getMvnLibs(MvnLibFilterDTO filter) {
        Pair<List<MvnLibPO>, Integer> p = this.mvnDataService
                .allMvnLibAndFilter(filter);
        List<MvnLibPO> mvnLibs = p.getFirst();
        List<MvnLibVO> res = new ArrayList<>();
        mvnLibs.forEach(cur -> {
            res.add(MvnLibVO.build(cur));
        });
        return new MvnLibListVO(p.getSecond(), res);
    }

    @Override
    public MvnProjVO getSpecificMvnProj(Integer projectId, String version) {
        MvnProjPO mvnProjPO = this.mvnDataService.getMvnProj(projectId, version);
        if (MvnProjPO.isNullInstance(mvnProjPO)) throw new CustomException(ReturnMessage.NoSuchProjExp.getMsg());
        List<MvnDepPO> mvnDeps = this.mvnDataService.allMvnDeps(projectId, version);
        List<MvnDepVO> res = new ArrayList<>();
        mvnDeps.forEach(cur -> {
            MvnLibPO lib = this.mvnDataService.getMvnLib(cur.getLibId());
            res.add(MvnDepVO.build(lib, cur.getLibVersion()));
        });
        return MvnProjVO.build(mvnProjPO, res);
    }

    @Override
    public MvnNewestProjVO getNewestMvnProj(Integer projectId) {
        MvnProjPO po = this.mvnDataService.getNewestMvnProj(projectId);
        if (MvnProjPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchProjExp.getMsg());
        return MvnNewestProjVO.build(po, this.mvnDataService.allMvnProjVersions(projectId));
    }

    @Override
    public MvnLibVO getSpecificMvnLib(String groupId, String artifactId) {
        MvnLibPO po = mvnDataService.getMvnLib(groupId, artifactId);
        if (MvnLibPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchMvnLibExp.getMsg());
        return MvnLibVO.build(po);
    }

    @Override
    public MvnLibVO getSpecificMvnLib(Integer libId) {
        MvnLibPO po = mvnDataService.getMvnLib(libId);
        if (MvnLibPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchMvnLibExp.getMsg());
        return MvnLibVO.build(po);
    }

}
