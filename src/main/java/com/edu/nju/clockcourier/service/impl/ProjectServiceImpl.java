package com.edu.nju.clockcourier.service.impl;

import com.edu.nju.clockcourier.config.ConstConfig;
import com.edu.nju.clockcourier.constant.ReturnMessage;
import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.exception.CustomException;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.service.ProjectService;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDataService projectDataService;
    private final ConstConfig config;

    @Autowired
    public ProjectServiceImpl(ProjectDataService projectDataService,
                              ConstConfig config) {
        this.projectDataService = projectDataService;
        this.config = config;
    }

    @Override
    public ProjectVO getProject(Integer id) {
        ProjectPO po = projectDataService.getProject(id);
        if (ProjectPO.isNullInstance(po)) throw new CustomException(ReturnMessage.NoSuchProjectExp.getMsg());
        return ProjectVO.build(po);
    }

    @Override
    public ProjectListVO getProjects(ProjFilterDTO filter) {
        return null;
    }

}
