package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.constant.ProjSortRule;
import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.po.RepositoryPO;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProjectServiceTest {

    private final ProjectService projectService;

    @Autowired
    public ProjectServiceTest(ProjectService projectService){
        this.projectService=projectService;
    }

    @Test
    void getProjectTest(){
        ProjectVO vo=projectService.getProject(31613);
        assertEquals("1pass",vo.getProjectName());
    }

    @Test
    void getProjectsTest(){
        ProjFilterDTO filter=new ProjFilterDTO();
        filter.setIsReverse(true);
        filter.setPage(1);
        filter.setLanguage("PHP");
        filter.setSort(ProjSortRule.CreateT);

        ProjectListVO listVO=projectService.getProjects(filter);
        List<ProjectVO> vos=listVO.getProjects();
        for(ProjectVO vo:vos){
            assertEquals("PHP",vo.getLanguage());
        }
    }

    @Test
    void getDependenciesTest(){

    }
}
