package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.constant.RepoSortRule;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RepoIntegrationTest {

    private final RepositoryController repositoryController;

    @Autowired
    public RepoIntegrationTest(RepositoryController controller) {
        this.repositoryController = controller;
    }

    // id: L1-3
    @Test
    public void queryTest1() {
        RepoFilterDTO dto = new RepoFilterDTO();
        dto.setRepositoryOwner("scale");
        dto.setPage(1);
        dto.setSort(RepoSortRule.ForkCount);
        dto.setIsReverse(true);
        List<RepositoryVO> vos = repositoryController
                .query(dto)
                .getData()
                .getRepositories();
        RepositoryVO last = null;
        for (RepositoryVO i : vos) {
            assertTrue(i.getRepositoryOwner().toLowerCase().contains("scale"));
            if (last == null) {
                last = i;
                continue;
            }
            assertTrue(i.getForkCount() <= last.getForkCount());
            last = i;
        }
    }

    // id: L1-4
    @Test
    public void queryTest2() {
        RepoFilterDTO dto = new RepoFilterDTO();
        dto.setHostType("GitHub");
        dto.setPage(1);
        dto.setSort(RepoSortRule.StarCount);
        dto.setIsReverse(true);
        List<RepositoryVO> vos = repositoryController
                .query(dto)
                .getData()
                .getRepositories();
        RepositoryVO last = null;
        for (RepositoryVO i : vos) {
            assertTrue(i.getHostType().contains("GitHub"));
            if (last == null) {
                last = i;
                continue;
            }
            assertTrue(i.getStarCount() <= last.getStarCount());
            last = i;
        }
    }

    // id: L2-3
    @Test
    public void depQueryTest1() {
        int id = 184295;
        RepoDepFilterDTO dto = new RepoDepFilterDTO();
        dto.setPage(1);
        dto.setIsReverse(false);
        List<RepoDepVO> vos = repositoryController
                .queryDependencies(String.valueOf(id), dto)
                .getData()
                .getRepoDeps();
        for (RepoDepVO i : vos) {
            assertTrue(i.getRepositoryName().contains("react"));
        }
    }

    // id: L2-4
    @Test
    public void depQueryTest2() {
        int id = 927214;
        RepoDepFilterDTO dto = new RepoDepFilterDTO();
        dto.setPage(1);
        dto.setIsReverse(false);
        List<RepoDepVO> vos = repositoryController
                .queryDependencies(String.valueOf(id), dto)
                .getData()
                .getRepoDeps();
        for (RepoDepVO i : vos) {
            assertTrue(i.getRepositoryName().contains("spring-boot"));
        }
    }

}