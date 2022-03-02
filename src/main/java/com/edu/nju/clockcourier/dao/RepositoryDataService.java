package com.edu.nju.clockcourier.dao;


import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import org.springframework.data.util.Pair;

import java.util.List;

public interface RepositoryDataService {

    RepositoryPO getRepository(Integer id);

    Pair<List<RepositoryPO>,Integer> allAndFilter(RepoFilterDTO filter, int pageSize);

    Pair<List<RepositoryDependencyPO>,Integer> allDepAndFilter(Integer repositoryId, RepoDepFilterDTO filter, int pageSize);

}
