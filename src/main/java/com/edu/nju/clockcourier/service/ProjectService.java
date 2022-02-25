package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;

public interface ProjectService {

    ProjectVO getProject(Integer id);

    ProjectListVO getProjects(ProjFilterDTO filter);

}
