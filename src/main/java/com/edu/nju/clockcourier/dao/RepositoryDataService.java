package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;

import java.util.List;

public interface RepositoryDataService {

    RepositoryPO getRepository(Integer id);

    List<RepositoryPO> allAndFilter(RepoFilterDTO filter,int pageSize);

    List<RepositoryDependencyPO> depAndFilter(Integer repositoryId, RepoDepFilterDTO filter, int pageSize);
}
