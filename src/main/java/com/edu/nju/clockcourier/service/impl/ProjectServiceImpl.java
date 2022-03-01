package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.service.ProjectService;
import com.edu.nju.clockcourier.vo.ProjDepListVO;
import com.edu.nju.clockcourier.vo.ProjDepVO;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDataService projectDataService;
    private final DatabaseConfig config;

    @Autowired
    public ProjectServiceImpl(ProjectDataService projectDataService,
                              DatabaseConfig config) {
        this.projectDataService = projectDataService;
        this.config = config;
    }

    @Override
    public ProjectVO getProject(Integer id) {
        ProjectPO po = projectDataService.getProject(id);
        if (ProjectPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchProjExp.getMsg());
        return ProjectVO.build(po);
    }

    @Override
    public ProjectListVO getProjects(ProjFilterDTO filter) {
        int pageSize = Integer.parseInt(config.getPageSize());
        PageInfo<ProjectPO> pi = projectDataService.allAndFilter(filter, pageSize);
        List<ProjectVO> vos = pi.getList()
                .stream()
                .map(ProjectVO::build)
                .collect(Collectors.toList());
        return new ProjectListVO(pi.getPages(), pageSize, vos);
    }

    @Override
    public ProjDepListVO getDependencies(Integer projectId, ProjDepFilterDTO filter) {
        int pageSize = Integer.parseInt(config.getPageSize());
        List<ProjDepVO> vos = projectDataService.allDepAndFilter(projectId, filter, pageSize)
                .stream()
                .map(ProjDepVO::build)
                .collect(Collectors.toList());
        return new ProjDepListVO(filter.getPage(), pageSize, vos);
    }

}
