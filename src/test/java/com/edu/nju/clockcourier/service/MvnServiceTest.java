package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.constant.MvnProjSortRule;
import com.edu.nju.clockcourier.dao.MvnDataService;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.po.MvnDepPO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjPO;
import com.edu.nju.clockcourier.service.impl.MvnServiceImpl;
import com.edu.nju.clockcourier.vo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class MvnServiceTest {

    @Mock
    private MvnDataService mvnDataService;

    @InjectMocks
    private MvnServiceImpl mvnService;

    private static MvnProjPO mvnProjPO;

    private static MvnDepPO mvnDepPO;

    private static MvnLibPO mvnLibPO;

    private static MvnProjFilterDTO mvnProjFilterDTO;

    private static MvnLibFilterDTO mvnLibFilterDTO;

    private static Pair<List<MvnProjPO>, Integer> projPair;

    private static Pair<List<MvnLibPO>, Integer> libPair;


    @BeforeAll
    public static void initData() {
        mvnProjPO = new MvnProjPO();
        mvnProjPO.setGroupId("de.sciss");
        mvnProjPO.setName("TreeTable");
        mvnProjPO.setArtifactId("treetable");
        mvnProjPO.setProjectId(1);
        mvnProjPO.setDescription("A TreeTable component for Swing");
        mvnProjPO.setUrl("https://github.com/Sciss/TreeTable");
        mvnProjPO.setVersion("1.3.4");

        mvnDepPO = new MvnDepPO();
        mvnDepPO.setProjectId(1);
        mvnDepPO.setVersion("1.3.4");
        mvnDepPO.setLibId(1);
        mvnDepPO.setLibVersion("1.0.0");

        mvnLibPO = new MvnLibPO();
        mvnLibPO.setLibId(5991);
        mvnLibPO.setGroupId("android");
        mvnLibPO.setArtifactId("android");

        mvnProjFilterDTO = new MvnProjFilterDTO();
        mvnProjFilterDTO.setSort(MvnProjSortRule.ArtifactId);
        mvnProjFilterDTO.setIsReverse(false);
        mvnProjFilterDTO.setGroupId("a");
        mvnProjFilterDTO.setArtifactId("a");
        mvnProjFilterDTO.setStartIndex(0);
        mvnProjFilterDTO.setEndIndex(1);

        mvnLibFilterDTO = new MvnLibFilterDTO();
        mvnLibFilterDTO.setSort(MvnLibSortRule.ArtifactId);
        mvnLibFilterDTO.setIsReverse(false);
        mvnLibFilterDTO.setStartIndex(0);
        mvnLibFilterDTO.setEndIndex(2);
        mvnLibFilterDTO.setGroupId("c");

        List<MvnProjPO> mvnProjPos = new ArrayList<>();
        mvnProjPos.add(mvnProjPO);
        projPair = Pair.of(mvnProjPos, 1);

        List<MvnLibPO> mvnLibPos = new ArrayList<>();
        mvnLibPos.add(mvnLibPO);
        libPair = Pair.of(mvnLibPos, 1);
    }


    @Test
    void getMvnProjectsTest() {
        List<String> versions = new ArrayList<>();
        given(mvnDataService.allMvnProjAndFilterNewest(mvnProjFilterDTO)).willReturn(projPair);
        given(mvnDataService.allMvnProjVersions(1)).willReturn(versions);
        MvnProjListVO mvnProjListVO = mvnService.getMvnProjects(mvnProjFilterDTO);
        assertEquals(1, mvnProjListVO.getCount());
        for (MvnNewestProjVO vo : mvnProjListVO.getProjects()) {
            assertEquals("de.sciss", vo.getGroupId());
        }

    }

    @Test
    void getMvnLibsTest() {
        given(mvnDataService.allMvnLibAndFilter(mvnLibFilterDTO)).willReturn(libPair);
        MvnLibListVO mvnLibListVO = mvnService.getMvnLibs(mvnLibFilterDTO);
        assertEquals(1, mvnLibListVO.getCount());
        for (MvnLibVO vo : mvnLibListVO.getLibs()) {
            assertEquals("android", vo.getArtifactId());
        }

    }

    @Test
    void getSpecificMvnProjTest() {
        List<MvnDepPO> mvnDepPOS = new ArrayList<>();
        mvnDepPOS.add(mvnDepPO);
        given(mvnDataService.getMvnProj(1, "1.3.4")).willReturn(mvnProjPO);
        given(mvnDataService.allMvnDeps(1, "1.3.4")).willReturn(mvnDepPOS);
        given(mvnDataService.getMvnLib(1)).willReturn(mvnLibPO);
        MvnProjVO vo = mvnService.getSpecificMvnProj(1, "1.3.4");
        assertEquals("treetable", vo.getArtifactId());
    }

    @Test
    void getNewestMvnProjTest() {
        List<String> versions = new ArrayList<>();
        versions.add("1.3.4");
        given(mvnDataService.getNewestMvnProj(1)).willReturn(mvnProjPO);
        given(mvnDataService.allMvnProjVersions(1)).willReturn(versions);
        MvnNewestProjVO vo = mvnService.getNewestMvnProj(1);
        assertEquals("treetable", vo.getArtifactId());
    }

    @Test
    void getSpecificMvnLibTest() {
        given(mvnDataService.getMvnLib(1)).willReturn(mvnLibPO);
        MvnLibVO vo = mvnService.getSpecificMvnLib(1);
        assertEquals("android", vo.getArtifactId());
    }

}