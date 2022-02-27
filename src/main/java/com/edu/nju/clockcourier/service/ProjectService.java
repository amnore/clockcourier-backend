package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.vo.ProjDepListVO;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import com.edu.nju.clockcourier.vo.RepoDepListVO;

public interface ProjectService {

    ProjectVO getProject(Integer id);

    ProjectListVO getProjects(ProjFilterDTO filter);

    ProjDepListVO getDependencies(Integer projectId, ProjDepFilterDTO filter);

}
