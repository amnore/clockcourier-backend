package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.constant.ProjSortRule;
import com.edu.nju.clockcourier.dto.ProjDepFilterDTO;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.util.Sorter;
import com.edu.nju.clockcourier.vo.ProjDepVO;
import com.edu.nju.clockcourier.vo.ProjectVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProjIntegrationTest {

    private final ProjectController projectController;

    @Autowired
    public ProjIntegrationTest(ProjectController projectController) {
        this.projectController = projectController;
    }

    // id: L1-1
    @Test
    public void queryTest1() {
        ProjFilterDTO dto = new ProjFilterDTO();
        dto.setName("font");
        dto.setPage(1);
        dto.setSort(ProjSortRule.Name);
        dto.setIsReverse(false);
        List<ProjectVO> vos = projectController
                .query(dto)
                .getData()
                .getProjects();
        ProjectVO last = null;
        for (ProjectVO i : vos) {
            assertTrue(i.getProjectName().contains("font"));
            if (last == null) {
                last = i;
                continue;
            }
            assertTrue(Sorter.DictCompare(i.getProjectName(), last.getProjectName()) > 0);
            last = i;
        }
    }

    // id: L1-2
    @Test
    public void queryTest2() {
        ProjFilterDTO dto = new ProjFilterDTO();
        dto.setLanguage("Ruby");
        dto.setPage(1);
        dto.setSort(ProjSortRule.CreateT);
        dto.setIsReverse(false);
        List<ProjectVO> vos = projectController
                .query(dto)
                .getData()
                .getProjects();
        ProjectVO last = null;
        for (ProjectVO i : vos) {
            assertTrue(i.getLanguage().contains("Ruby"));
            if (last == null) {
                last = i;
                continue;
            }
            assertTrue(i.getCreateT().getTime() >= last.getCreateT().getTime());
            last = i;
        }
    }

    // id: L2-1
    @Test
    public void depQueryTest1() {
        int id = 40765;
        ProjDepFilterDTO dto = new ProjDepFilterDTO();
        dto.setPage(1);
        dto.setIsReverse(false);
        List<ProjDepVO> vos = projectController
                .queryDependencies(String.valueOf(id), dto)
                .getData()
                .getProjDeps();
        for (ProjDepVO i : vos) {
            assertTrue(i.getProjectName().contains("0mq"));
        }
    }

    // id: L2-2
    @Test
    public void depQueryTest2() {
        int id = 92905;
        ProjDepFilterDTO dto = new ProjDepFilterDTO();
        dto.setPage(1);
        dto.setIsReverse(false);
        List<ProjDepVO> vos = projectController
                .queryDependencies(String.valueOf(id), dto)
                .getData()
                .getProjDeps();
        for (ProjDepVO i : vos) {
            assertTrue(i.getProjectName().contains("bgg"));
        }
    }

}