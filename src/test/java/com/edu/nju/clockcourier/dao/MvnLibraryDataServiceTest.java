package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MvnLibraryDataServiceTest {

    private final MvnLibraryDataService mvnDataService;

    @Autowired
    public MvnLibraryDataServiceTest(MvnLibraryDataService mvnDataService) {
        this.mvnDataService = mvnDataService;
    }

    @Test
    public void getMvnLib() {
        MvnLibPO mvnLibPO = this.mvnDataService.getMvnLib(1);
        assertEquals(1, mvnLibPO.getLibId());
    }

    @Test
    public void getMvnLib2() {
        MvnLibPO mvnLibPO = this.mvnDataService.getMvnLib("org.jbehave.web", "jbehave-trader-webapp");
        assertEquals("org.jbehave.web", mvnLibPO.getGroupId());
        assertEquals("jbehave-trader-webapp", mvnLibPO.getArtifactId());
    }

    @Test
    public void allMvnLibAndFilter() {

        MvnLibFilterDTO dto = new MvnLibFilterDTO();
        dto.setArtifactId("ja");
        dto.setGroupId("org");
        dto.setSort(MvnLibSortRule.ArtifactId);
        dto.setStartIndex(1);
        dto.setEndIndex(2);
        dto.setIsReverse(true);

        var pair = mvnDataService.allMvnLibAndFilter(dto);

        for (MvnLibPO lib : pair.getFirst()) {
            assertTrue(lib.getArtifactId().contains("ja"));
            assertTrue(lib.getGroupId().contains("org"));
        }
    }


}