package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.RepoSortRule;
import com.edu.nju.clockcourier.dao.RepositoryDataService;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import com.edu.nju.clockcourier.service.impl.RepositoryServiceImpl;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RepositoryServiceTest {

    @Mock
    private RepositoryDataService repositoryDataService;

    @Mock
    private DatabaseConfig config;

    @InjectMocks
    private RepositoryServiceImpl repositoryService;

    private static RepoFilterDTO repoFilterDTO;
    private static RepoDepFilterDTO repoDepFilterDTO;
    private static RepositoryPO po;
    private static Pair<List<RepositoryPO>, Integer> pair;
    private static Pair<List<RepositoryDependencyPO>, Integer> dpair;

    @BeforeAll
    private static void initData() {
        // dto
        repoFilterDTO = new RepoFilterDTO();
        repoFilterDTO.setIsReverse(true);
        repoFilterDTO.setCanFork(true);
        repoFilterDTO.setPage(1);
        repoFilterDTO.setSort(RepoSortRule.CreateT);
        repoFilterDTO.setLanguage("PHP");
        repoDepFilterDTO = new RepoDepFilterDTO();
        repoDepFilterDTO.setPage(1);
        repoDepFilterDTO.setIsReverse(true);
        // po pair
        po = new RepositoryPO();
        po.setRepositoryName("gentleface-sprites");
        po.setFork(0);
        po.setLanguage("PHP");
        List<RepositoryPO> pos = new ArrayList<>();
        pos.add(po);
        pair = Pair.of(pos, 1);
        // dpair
        RepositoryDependencyPO dpo = new RepositoryDependencyPO();
        dpo.setRepositoryName("redshift_console");
        List<RepositoryDependencyPO> dpos = new ArrayList<>();
        dpos.add(dpo);
        dpair = Pair.of(dpos, 1);
    }

    @Test
    public void getRepositoryTest() {
        given(repositoryDataService.getRepository(427)).willReturn(po);
        RepositoryVO vo = repositoryService.getRepository(427);
        assertEquals("gentleface-sprites", vo.getRepositoryName());
    }

    @Test
    void getRepositoriesTest() {
        given(config.getPageSize()).willReturn(String.valueOf(15));
        given(repositoryDataService.allAndFilter(repoFilterDTO, 15))
                .willReturn(pair);
        RepositoryListVO listVO = repositoryService.getRepositories(repoFilterDTO);
        List<RepositoryVO> vos = listVO.getRepositories();
        for (RepositoryVO vo : vos) {
            assertEquals("PHP", vo.getLanguage());
        }
    }

    @Test
    void getDependenciesTest() {
        given(config.getPageSize()).willReturn(String.valueOf(15));
        given(repositoryDataService.allDepAndFilter(396715, repoDepFilterDTO, 15))
                .willReturn(dpair);
        RepoDepListVO listVO = repositoryService.getDependencies(396715, repoDepFilterDTO);
        List<RepoDepVO> vos = listVO.getRepoDeps();
        for (RepoDepVO vo : vos) {
            assertEquals("redshift_console", vo.getRepositoryName());
        }
    }

}
