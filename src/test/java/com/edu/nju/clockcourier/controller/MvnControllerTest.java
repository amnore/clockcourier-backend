package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.constant.MvnProjSortRule;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.vo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MvnControllerTest {

    @Autowired
    private MvnController mvnController;

    @Test
    void getMvnLib() {
        MvnLibVO lib = mvnController.getMvnLib(2005).getData();
        assertEquals("mxmlc", lib.getArtifactId());
        assertEquals(".compiler", lib.getGroupId());
    }

    @Test
    void getMvnLibList() {
        MvnLibFilterDTO filter = new MvnLibFilterDTO();
        filter.setSort(MvnLibSortRule.ArtifactId);
        filter.setIsReverse(false);
        filter.setStartIndex(0);
        filter.setEndIndex(10);
        filter.setArtifactId("zz");
        MvnLibListVO libList = mvnController.getMvnLibList(filter).getData();
        for (MvnLibVO vo : libList.getLibs()) {
            assertTrue(vo.getArtifactId().contains("zz"));
        }
    }

    @Test
    void getMvnProjList() {
        MvnProjFilterDTO filter = new MvnProjFilterDTO();
        filter.setSort(MvnProjSortRule.ArtifactId);
        filter.setIsReverse(false);
        filter.setStartIndex(0);
        filter.setEndIndex(10);
        filter.setArtifactId("zz");
        MvnProjListVO mvnProjList = mvnController.getMvnProjList(filter).getData();
        for (MvnNewestProjVO vo : mvnProjList.getProjects()) {
            assertTrue(vo.getArtifactId().contains("zz"));
        }
    }

    @Test
    void getSpecificMvnProj() {
        MvnProjVO vo = mvnController.getSpecificMvnProj("1", "1.3.0").getData();
        assertEquals("de.sciss", vo.getGroupId());
        assertEquals("treetable", vo.getArtifactId());
        assertEquals("TreeTable", vo.getName());
    }

    @Test
    void testGetNewestMvnProj() {
        MvnNewestProjVO vo = mvnController.getNewestMvnProj("1").getData();
        assertEquals("de.sciss", vo.getGroupId());
        assertEquals("treetable", vo.getArtifactId());
        assertEquals("TreeTable", vo.getName());
    }
}