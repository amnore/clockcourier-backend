package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectDependencyPO;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProjectDataService {

    ProjectPO getProject(Integer id);

    PageInfo<ProjectPO> allAndFilter(ProjFilterDTO filter, int pageSize);

    List<ProjectDependencyPO> allDepAndFilter(Integer projectId, ProjDepFilterDTO filter, int pageSize);

}
