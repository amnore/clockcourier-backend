package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.util.Sorter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void getMvnLibTest() {
        MvnLibPO mvnLibPO1 = this.mvnDataService.getMvnLib(1);
        assertEquals(1, mvnLibPO1.getLibId());
        MvnLibPO mvnLibPO2 = this.mvnDataService.getMvnLib("org.jbehave.web", "jbehave-trader-webapp");
        assertEquals("org.jbehave.web", mvnLibPO2.getGroupId());
        assertEquals("jbehave-trader-webapp", mvnLibPO2.getArtifactId());
    }

    @Test
    public void allMvnLibAndFilterTest() {
        MvnLibFilterDTO dto = new MvnLibFilterDTO();
        dto.setArtifactId("ja");
        dto.setGroupId("org");
        dto.setSort(MvnLibSortRule.ArtifactId);
        dto.setStartIndex(10);
        dto.setEndIndex(20);
        dto.setIsReverse(true);
        // test case 1
        Pair<List<MvnLibPO>, Integer> pair1 = mvnDataService.allMvnLibAndFilter(dto);
        for (MvnLibPO lib : pair1.getFirst()) {
            assertTrue(lib.getArtifactId().contains("ja"));
            assertTrue(lib.getGroupId().contains("org"));
        }
        // test case 2
        dto.setArtifactId(null);
        Pair<List<MvnLibPO>, Integer> pair2 = mvnDataService.allMvnLibAndFilter(dto);
        for (MvnLibPO lib : pair2.getFirst()) {
            assertTrue(lib.getGroupId().contains("org"));
        }
        // test case 3
        dto.setIsReverse(false);
        Pair<List<MvnLibPO>, Integer> pair3 = mvnDataService.allMvnLibAndFilter(dto);
        MvnLibPO last = null;
        for (MvnLibPO lib : pair3.getFirst()) {
            assertTrue(lib.getGroupId().contains("org"));
            if (last != null) {
                assertTrue(Sorter.DictCompare(lib.getArtifactId(), last.getArtifactId()) >= 0);
            }
            last = lib;
        }
        // test case 4
        dto.setIsReverse(true);
        dto.setSort(MvnLibSortRule.RuleNum);
        dto.setGroupId(null);
        Pair<List<MvnLibPO>, Integer> pair4 = mvnDataService.allMvnLibAndFilter(dto);
        last = null;
        for (MvnLibPO lib : pair4.getFirst()) {
            if (last != null) {
                assertTrue(last.getStartRuleNum() >= lib.getStartRuleNum());
            }
            last = lib;
        }
    }

    @Test
    public void allMvnLibIdTest() {
        List<Integer> list = this.mvnDataService.allMvnLibId();
        // 184774 来自 select count(*)
        assertEquals(184774, list.size());
    }

    @Test
    @Transactional
    public void updateStartRuleNumTest() {
        int lib = 1;
        int old = this.mvnDataService.getMvnLib(lib).getStartRuleNum();
        this.mvnDataService.updateStartRuleNum(lib, old + 1);
        assertEquals(old + 1, this.mvnDataService.getMvnLib(lib).getStartRuleNum());
        this.mvnDataService.updateStartRuleNum(lib, old);
        assertEquals(old, this.mvnDataService.getMvnLib(lib).getStartRuleNum());
    }

}