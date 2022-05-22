package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Disabled
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
        MvnLibPO mvnLibPO = this.mvnDataService.getMvnLib("1", "2");
        assertEquals("1", mvnLibPO.getGroupId());
        assertEquals("2", mvnLibPO.getArtifactId());
    }

    @Test
    public void allMvnLibAndFilter() {

        MvnLibFilterDTO dto = new MvnLibFilterDTO();
        dto.setArtifactId("1");
        dto.setGroupId("2");
        dto.setSort(MvnLibSortRule.ArtifactId);
        dto.setStartIndex(1);
        dto.setEndIndex(2);
        dto.setIsReverse(true);

        var pair = mvnDataService.allMvnLibAndFilter(dto);

        for (MvnLibPO lib : pair.getFirst()) {
            assertEquals("1", lib.getArtifactId());
            assertEquals("2", lib.getGroupId());
        }
    }


}