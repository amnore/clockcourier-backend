package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.constant.RepoSortRule;
import com.edu.nju.clockcourier.dto.RepoDepFilterDTO;
import com.edu.nju.clockcourier.dto.RepoFilterDTO;
import com.edu.nju.clockcourier.vo.RepoDepListVO;
import com.edu.nju.clockcourier.vo.RepoDepVO;
import com.edu.nju.clockcourier.vo.RepositoryListVO;
import com.edu.nju.clockcourier.vo.RepositoryVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositoryServiceTest {

    private final RepositoryService repositoryService;

    @Autowired
    public RepositoryServiceTest(RepositoryService repositoryService){
        this.repositoryService=repositoryService;
    }

    @Test
    void getRepositoryTest(){
        RepositoryVO vo=repositoryService.getRepository(427);
        assertEquals("gentleface-sprites",vo.getRepositoryName());
    }

    @Test
    void getRepositoriesTest(){
        RepoFilterDTO filter=new RepoFilterDTO();

        filter.setIsReverse(true);
        filter.setCanFork(true);
        filter.setPage(1);
        filter.setSort(RepoSortRule.CreateT);
        filter.setLanguage("PHP");

        RepositoryListVO listVO=repositoryService.getRepositories(filter);

        List<RepositoryVO> vos=listVO.getRepositories();

        for(RepositoryVO vo:vos){
            assertEquals("PHP",vo.getLanguage());
        }


    }

    @Test
    void getDependenciesTest(){
        RepoDepFilterDTO filter=new RepoDepFilterDTO();

        filter.setPage(1);
        filter.setIsReverse(true);

        RepoDepListVO listVO=repositoryService.getDependencies(396715,filter);

        List<RepoDepVO> vos=listVO.getRepoDeps();

        for(RepoDepVO vo:vos){
            assertEquals("redshift_console",vo.getRepositoryName());
        }

    }

}
