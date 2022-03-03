package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.RepoSortRule;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RepositoryDataServiceTest {

    private final RepositoryDataService repositoryDataService;
    private final DatabaseConfig config;

    @Autowired
    public RepositoryDataServiceTest(RepositoryDataService repositoryDataService, DatabaseConfig databaseConfig) {
        this.repositoryDataService = repositoryDataService;
        this.config = databaseConfig;
    }

    @Test
    void getRepositoryTest() {
        RepositoryPO repositoryPO = repositoryDataService.getRepository(427);
        String ExpectName = repositoryPO.getRepositoryName();
        assertEquals("gentleface-sprites", repositoryPO.getRepositoryName());
    }

    @Test
    void allAndFilterTest() {
        RepoFilterDTO filter = new RepoFilterDTO();
        filter.setSort(RepoSortRule.CreateT);
        filter.setPage(1);
        filter.setLanguage("PHP");
        filter.setCanFork(true);
        filter.setIsReverse(true);
        int pageSize = Integer.parseInt(config.getPageSize());
        Pair<List<RepositoryPO>, Integer> pair = repositoryDataService.allAndFilter(filter, pageSize);
        List<RepositoryPO> pos = pair.getFirst();
        for (RepositoryPO po : pos) {
            assertEquals("PHP", po.getLanguage());
        }
    }

    @Test
    void allDepAndFilterTest() {
        RepoDepFilterDTO filter = new RepoDepFilterDTO();
        filter.setPage(1);
        filter.setIsReverse(true);
        int pageSize = Integer.parseInt(config.getPageSize());
        Pair<List<RepositoryDependencyPO>, Integer> pair = repositoryDataService.allDepAndFilter(396715, filter, pageSize);
        List<RepositoryDependencyPO> pos = pair.getFirst();
        for (RepositoryDependencyPO po : pos) {
            assertEquals("redshift_console", po.getRepositoryName());
        }
    }

}