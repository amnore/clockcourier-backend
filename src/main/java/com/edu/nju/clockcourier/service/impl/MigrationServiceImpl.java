package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.po.RuleInstancePO;
import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.service.MvnProjectService;
import com.edu.nju.clockcourier.vo.MigrationInstanceListVO;
import com.edu.nju.clockcourier.vo.MigrationInstanceVO;
import com.edu.nju.clockcourier.vo.MigrationNodeVO;
import com.edu.nju.clockcourier.vo.MvnProjVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MigrationServiceImpl implements MigrationService {

    private final MigrationDataService dataService;
    private final MvnProjectService mvnProjectService;

    @Autowired
    public MigrationServiceImpl(MigrationDataService dataService, MvnProjectService mvnProjectService) {
        this.dataService = dataService;
        this.mvnProjectService = mvnProjectService;
    }

    @Override
    public List<MigrationNodeVO> getMigrationGraph(Integer libId) {
        return null;
    }

    //获取迁移实例
    @Override
    public MigrationInstanceListVO getInstance(Integer ruleId, Integer page) {

        // 根据 ruleId 获取迁移规则实例列表
        List<RuleInstancePO> ruleInstancePOS = dataService.getInstance(ruleId, page);
        List<MigrationInstanceVO> migrationInstanceVOS = new ArrayList<>();
        // 对每个实例 查找对应的项目信息 组合成具体实例返回
        ruleInstancePOS.forEach(cur -> {
            MvnProjVO mvnProjVO = this.mvnProjectService.getMvnProject(cur.getProjectId());
            migrationInstanceVOS.add(new MigrationInstanceVO(
                    cur.getRuleId(),
                    mvnProjVO.getName(),
                    cur.getProjectId(),
                    cur.getFileName(),
                    mvnProjVO.getName(),
                    cur.getStartCommitLink(),
                    cur.getEndCommitLink()));
        });
        int count = ruleInstancePOS.size();
        return new MigrationInstanceListVO(count, migrationInstanceVOS);
    }
}
