package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.ProjSortRule;
import com.edu.nju.clockcourier.dao.ProjectDataService;
import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectDependencyPO;
import com.edu.nju.clockcourier.po.ProjectPO;
import com.edu.nju.clockcourier.service.impl.ProjectServiceImpl;
import com.edu.nju.clockcourier.vo.ProjDepListVO;
import com.edu.nju.clockcourier.vo.ProjDepVO;
import com.edu.nju.clockcourier.vo.ProjectListVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
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
public class ProjectServiceTest {

    @Mock
    private ProjectDataService projectDataService;

    @Mock
    private DatabaseConfig config;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private static ProjFilterDTO projectFilter;
    private static ProjDepFilterDTO projDepFilter;
    private static ProjectPO po;
    private static Pair<List<ProjectPO>, Integer> pair;
    private static Pair<List<ProjectDependencyPO>, Integer> dpair;

    @BeforeAll
    public static void initData() {
        // dto
        projectFilter = new ProjFilterDTO();
        projectFilter.setIsReverse(true);
        projectFilter.setPage(1);
        projectFilter.setLanguage("PHP");
        projectFilter.setSort(ProjSortRule.CreateT);
        // po pos pair
        po = new ProjectPO();
        po.setProjectId(31613);
        po.setProjectName("1pass");
        po.setLanguage("PHP");
        List<ProjectPO> pos = new ArrayList<>();
        pos.add(po);
        pair = Pair.of(pos, 1);
        // dpo dpos dpair
        ProjectDependencyPO dpo = new ProjectDependencyPO();
        dpo.setDependencyProjectName("corneltek/getoptionkit");
        List<ProjectDependencyPO> dpos = new ArrayList<>();
        dpos.add(dpo);
        dpair = Pair.of(dpos, 1);
    }

    @Test
    public void getProjectTest() {
        given(projectDataService.getProject(31613)).willReturn(po);
        ProjectVO vo = projectService.getProject(31613);
        assertEquals("1pass", vo.getProjectName());
    }

    @Test
    public void getProjectsTest() {
        given(config.getPageSize()).willReturn(String.valueOf(15));
        given(projectDataService.allAndFilter(projectFilter, 15)).willReturn(pair);
        ProjectListVO listVO = projectService.getProjects(projectFilter);
        List<ProjectVO> vos = listVO.getProjects();
        for (ProjectVO vo : vos) {
            assertEquals("PHP", vo.getLanguage());
        }
    }

    @Test
    public void getDependenciesTest() {
        given(config.getPageSize()).willReturn(String.valueOf(15));
        given(projectDataService.allDepAndFilter(40532, projDepFilter, 15))
                .willReturn(dpair);
        ProjDepListVO listVO = projectService.getDependencies(40532, projDepFilter);
        List<ProjDepVO> vos = listVO.getProjDeps();
        for (ProjDepVO vo : vos) {
            assertEquals("corneltek/getoptionkit", vo.getDependencyProjectName());
        }
    }

}
