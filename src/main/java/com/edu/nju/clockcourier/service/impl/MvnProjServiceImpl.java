package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MvnProjDataService;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MvnDependencyPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import com.edu.nju.clockcourier.service.MvnProjService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MvnProjServiceImpl implements MvnProjService {

    private final MvnProjDataService mvnProjDataService;

    public MvnProjServiceImpl(MvnProjDataService mvnProjDataService){
        this.mvnProjDataService=mvnProjDataService;
    }

    @Override
    public MvnProjListVO query(MvnProjFilterDTO filter) {


        return null;
    }

    @Override
    public MvnProjVersionVO getMvn(Integer projectId, String version) {

        //找到该版本的PO
        MvnProjectPO mvnProjectPO=mvnProjDataService.getMvnProjVersion(projectId,version);

        //如果没找到，返回空
        if(MvnProjectPO.isNullInstance(mvnProjectPO)){
            return new MvnProjVersionVO();
        }

        //寻找对应依赖
        List<MvnDependencyPO> mvnDependencyPOS=mvnProjDataService.getMvnDep(projectId,version);

        List<MvnProjDepVO> mvnProjDepVOS=new ArrayList<>();

        //根据libId去寻找对应依赖
        for(MvnDependencyPO mvnDependencyPO:mvnDependencyPOS){
            String depVersion=mvnDependencyPO.getLibVersion();
            Integer depId=mvnDependencyPO.getLibId();
            MvnLibPO mvnLibPO=mvnProjDataService.getMvnLib(depId);
            mvnProjDepVOS.add(new MvnProjDepVO(depId
                    ,mvnLibPO.getGroupId()
                    ,mvnLibPO.getArtifactId()
                    ,depVersion));
        }

        return new MvnProjVersionVO(mvnProjectPO.getProjectId()
                                ,mvnProjectPO.getName()
                                ,mvnProjectPO.getGroupId()
                                ,mvnProjectPO.getArtifactId()
                                ,mvnProjectPO.getVersion()
                                ,mvnProjDepVOS);
    }

    @Override
    public MvnProjGraphVO getGraph(Integer projectId) {
        return null;
    }

    @Override
    public MvnProjVO getBase(Integer projectId) {
        //1.获取projectId对应的Maven项目
        List<MvnProjectPO> mvnProjectPOS=mvnProjDataService.getMvnProj(projectId);

        //如果没找到,返回空
        if(mvnProjectPOS.size()==0){
            //返回空VO
            return new MvnProjVO();
        }

        //2.获取所有的版本号
        List<String> versions=new ArrayList<>();
        for (MvnProjectPO mvnProjectPO : mvnProjectPOS) {
            versions.add(mvnProjectPO.getVersion());
        }
        MvnProjectPO p0=mvnProjectPOS.get(0);

        //3.返回VO
        return new MvnProjVO(p0.getProjectId(),
                p0.getName(),
                p0.getGroupId(),
                p0.getArtifactId(),
                versions,
                p0.getDescription(),
                p0.getUrl());
    }
}
