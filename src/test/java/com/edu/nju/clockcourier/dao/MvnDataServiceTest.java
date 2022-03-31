package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.constant.MvnProjSortRule;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MvnDataServiceTest {

    @Autowired
    private MvnDataService mvnDataService;


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
    void allMvnProjAndFilterNewest() {
        MvnProjFilterDTO filter = new MvnProjFilterDTO();
        filter.setSort(MvnProjSortRule.ArtifactId);
        filter.setIsReverse(false);
        filter.setGroupId("au.csiro");
        filter.setStartIndex(0);
        filter.setEndIndex(1);
        Pair<List<MvnProjPO>, Integer> actual = mvnDataService.allMvnProjAndFilterNewest(filter);
        List<MvnProjPO> pos = actual.getFirst();
        for (MvnProjPO po : pos) {
            assertEquals(po.getGroupId(), "au.csiro");
        }

    }

    @Test
    void allMvnLibAndFilter() {
        MvnLibFilterDTO filter = new MvnLibFilterDTO();
        filter.setSort(MvnLibSortRule.ArtifactId);
        filter.setIsReverse(false);
        filter.setStartIndex(0);
        filter.setEndIndex(2);
        filter.setGroupId("cglib");
        Pair<List<MvnLibPO>, Integer> actual = mvnDataService.allMvnLibAndFilter(filter);
        List<MvnLibPO> pos = actual.getFirst();
        Integer num = actual.getSecond();
        for (MvnLibPO po : pos) {
            assertEquals(po.getGroupId(), "cglib");
        }
    }

    @Test
    void allMvnProjVersions() {
        List<String> versions = mvnDataService.allMvnProjVersions(1);
        assertEquals("1.3.0", versions.get(0));
    }

    @Test
    void allMvnDeps() {
        List<MvnDepPO> mvnDepPOList = mvnDataService.allMvnDeps(1, "1.3.0");
        for (MvnDepPO po : mvnDepPOList) {
            assertEquals(1, po.getProjectId());
        }
    }
}