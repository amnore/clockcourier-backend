package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;

public interface RepositoryService {

    RepositoryVO getRepository(Integer id);

    RepositoryListVO getRepositories(RepoFilterDTO repoFilterDTO);

    RepoDepListVO getDependencies(Integer repositoryId, RepoDepFilterDTO repoDepFilterDTO);
    
}
