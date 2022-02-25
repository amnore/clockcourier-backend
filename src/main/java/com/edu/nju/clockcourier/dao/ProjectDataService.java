package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectPO;

import java.util.List;

public interface ProjectDataService {

    ProjectPO getProject(Integer id);

    List<ProjectPO> allAndFilter(ProjFilterDTO filter, int pageSize);

}
