package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectDependencyPO;
import com.edu.nju.clockcourier.po.ProjectPO;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ProjectDataService {

    ProjectPO getProject(Integer id);

    Integer getMvnProjectId(String groupId, String artifactId);

    Pair<List<ProjectPO>, Integer> allAndFilter(ProjFilterDTO filter, int pageSize);

    Pair<List<ProjectDependencyPO>, Integer> allDepAndFilter(Integer projectId, ProjDepFilterDTO filter, int pageSize);

}
