package com.edu.nju.clockcourier.service.impl;
import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.service.ProjectService;
import com.edu.nju.clockcourier.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDataService projectDataService;

    @Autowired
    public ProjectServiceImpl(ProjectDataService projectDataService){
        this.projectDataService=projectDataService;
    }

    @Override
    public ProjectVO getProject(Integer id) {
        return ProjectVO.buildVO(projectDataService.getProject(id));
    }
}
