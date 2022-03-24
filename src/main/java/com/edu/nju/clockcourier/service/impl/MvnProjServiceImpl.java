package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MvnProjDataService;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import com.edu.nju.clockcourier.service.MvnProjService;
import com.edu.nju.clockcourier.vo.MvnProjGraphVO;
import com.edu.nju.clockcourier.vo.MvnProjListVO;
import com.edu.nju.clockcourier.vo.MvnProjVO;
import com.edu.nju.clockcourier.vo.MvnProjVersionVO;
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
        MvnProjectPO mvnProjectPO=mvnProjDataService.getMvnProjVersion(projectId,version);
        
        return null;
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
