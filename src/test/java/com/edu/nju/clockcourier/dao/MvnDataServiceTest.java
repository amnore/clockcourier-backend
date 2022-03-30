package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MvnDataServiceTest {

    @Autowired
    private MvnDataService mvnDataService;

    @Test
    void insertMvnLib() {
    }

    @Test
    void getMvnLib() {
        MvnLibPO lib = mvnDataService.getMvnLib(4763);
        String actual = lib.getGroupId();
        String expected = "ant";
        assertEquals(expected, actual);
    }

    @Test
    void testGetMvnLib() {
        MvnLibPO lib = mvnDataService.getMvnLib("ant", "ant");
        Integer actual = lib.getLibId();
        Integer expected = 4763;
        assertEquals(expected, actual);
    }

    @Test
    void insertMvnProjIfNotExists() {
    }

    @Test
    void getMvnProjIdIfExists() {
        Integer actual = mvnDataService.getMvnProjIdIfExists("de.sciss", "treetable");
        Integer expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getMvnProj() {
        MvnProjPO mvnProj = mvnDataService.getMvnProj(1, "1.3.0");
        String actual = mvnProj.getVersion();
        String expected = "1.3.0";
        assertEquals(expected, actual);
    }

    @Test
    void getNewestMvnProj() {
        MvnProjPO mvnProj = mvnDataService.getNewestMvnProj(1);
        String actual = mvnProj.getVersion();
        String expected = "1.3.4";
        assertEquals(expected, actual);
    }

    @Test
    void allMvnProjWithMultiVersions() {
     
    }

    @Test
    void allMvnProjAndFilterNewest() {

    }

    @Test
    void allMvnLibAndFilter() {
    }

    @Test
    void allMvnProjVersions() {
        List<String> versions = mvnDataService.allMvnProjVersions(1);
        assertEquals("1.3.0", versions.get(0));
    }

    @Test
    void insertMvnDepIfNotExists() {
    }

    @Test
    void allMvnDeps() {
        List<MvnDepPO> mvnDepPOList = mvnDataService.allMvnDeps(1, "1.3.0");
        for (MvnDepPO po : mvnDepPOList) {
            assertEquals(1, po.getProjectId());
        }
    }
}