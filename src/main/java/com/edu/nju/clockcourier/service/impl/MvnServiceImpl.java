package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.DisplayConfig;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dao.MvnLibraryDataService;
import com.edu.nju.clockcourier.dao.MvnProjectDataService;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import com.edu.nju.clockcourier.service.MvnService;
import com.edu.nju.clockcourier.util.PomAnalyser;
import com.edu.nju.clockcourier.vo.MvnLibListVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import com.edu.nju.clockcourier.vo.MvnProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MvnServiceImpl implements MvnService {

    private final MvnLibraryDataService mvnLibraryDataService;
    private final MvnProjectDataService mvnProjectDataService;
    private final DisplayConfig displayConfig;

    @Autowired
    public MvnServiceImpl(MvnLibraryDataService mvnLibraryDataService,
                          MvnProjectDataService mvnProjectDataService,
                          DisplayConfig config) {
        this.mvnLibraryDataService = mvnLibraryDataService;
        this.mvnProjectDataService = mvnProjectDataService;
        this.displayConfig = config;
    }

    @Override
    public MvnLibListVO getMvnLibs(MvnLibFilterDTO filter) {
        Pair<List<MvnLibPO>, Integer> p = this.mvnLibraryDataService
                .allMvnLibAndFilter(filter);
        List<MvnLibPO> mvnLibs = p.getFirst();
        List<MvnLibVO> res = mvnLibs.stream()
                .map(MvnLibVO::build)
                .collect(Collectors.toList());
        return new MvnLibListVO(displayConfig.pageAll(p.getSecond()), res);
    }

    @Override
    public MvnLibVO getSpecificMvnLib(Integer libId) {
        MvnLibPO po = mvnLibraryDataService.getMvnLib(libId);
        if (MvnLibPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchMvnLibExp.getMsg());
        return MvnLibVO.build(po);
    }

    private MvnLibVO getSpecificMvnLib(String groupId, String artifactId) {
        MvnLibPO po = mvnLibraryDataService.getMvnLib(groupId, artifactId);
        if (MvnLibPO.isNullInstance(po)) return null;
        return MvnLibVO.build(po);
    }

    // 解析 pom 文件并返回 lib 列表
    @Override
    public List<MvnLibVO> extractPomDeps(MvnPomAnalyseDTO dto) {
        // 调用工具类解析 pom 文件, 获取依赖的 groupId 和 artifactId
        List<Pair<String, String>> list = PomAnalyser.extractDeps(dto.getPom());
        // 如果 getSpecificMvnLib 返回 null, 说明数据库里没有这个 lib, 直接忽略
        return list.stream()
                .map(c -> this.getSpecificMvnLib(c.getFirst(), c.getSecond()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public MvnProjectVO getMvnProject(Integer projectId) {
        MvnProjectPO po = this.mvnProjectDataService.getProject(projectId);
        if (MvnProjectPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchMvnProjExp.getMsg());
        return MvnProjectVO.build(po);
    }

}
