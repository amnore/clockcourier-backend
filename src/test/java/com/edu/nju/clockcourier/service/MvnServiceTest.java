package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.config.DisplayConfig;
import com.edu.nju.clockcourier.dao.MvnLibraryDataService;
import com.edu.nju.clockcourier.dao.MvnProjectDataService;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import com.edu.nju.clockcourier.po.MvnProjectPO;
import com.edu.nju.clockcourier.service.impl.MvnServiceImpl;
import com.edu.nju.clockcourier.vo.MvnLibListVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import com.edu.nju.clockcourier.vo.MvnProjectVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;


@SpringBootTest
public class MvnServiceTest {

    @Mock
    private MvnLibraryDataService mvnLibraryDataService;

    @Mock
    private MvnProjectDataService mvnProjectDataService;

    @Mock
    private DisplayConfig displayConfig;

    @InjectMocks
    private MvnServiceImpl mvnService;

    private static MvnLibPO mvnLibPO;

    private static MvnLibPO mvnLibPO2;

    private static MvnProjectPO mvnProjectPO;

    private static Pair<List<MvnLibPO>, Integer> p;

    private static MvnLibFilterDTO dto;

    //初始化
    @BeforeAll
    public static void initData() {
        mvnLibPO = new MvnLibPO();
        mvnLibPO.setLibId(1);
        mvnLibPO.setArtifactId("1");
        mvnLibPO.setGroupId("2");
        mvnLibPO.setMvnCtrUrl("www");
        mvnLibPO.setDescription("des");
        mvnLibPO.setGithubUrl("s");

        mvnLibPO2 = new MvnLibPO();
        mvnLibPO2.setLibId(2);
        mvnLibPO2.setArtifactId("spring-boot-starter-data-jdbc");
        mvnLibPO2.setGroupId("org.springframework.boot");
        mvnLibPO2.setMvnCtrUrl("www");
        mvnLibPO2.setDescription("des");
        mvnLibPO2.setGithubUrl("s");

        mvnProjectPO = new MvnProjectPO();
        mvnProjectPO.setProjectId(1);
        mvnProjectPO.setName("project");
        mvnProjectPO.setUrl("www");

        List<MvnLibPO> mvnLibPOS = new ArrayList<>();
        mvnLibPOS.add(mvnLibPO);
        p = Pair.of(mvnLibPOS, 1);

        dto = new MvnLibFilterDTO();

    }

    @Test
    public void getMvnLibsTest() {
        given(mvnLibraryDataService.allMvnLibAndFilter(dto)).willReturn(p);
        given(displayConfig.pageAll(1)).willReturn(1);
        MvnLibListVO mvnLibListVO = mvnService.getMvnLibs(dto);
        for (MvnLibVO mvnLibVO : mvnLibListVO.getLibs()) {
            assertTrue(mvnLibVO.getArtifactId().contains("1"));
        }
        assertEquals(1, mvnLibListVO.getPageAll());
    }

    @Test
    public void getSpecificMvnLibTest() {
        given(mvnLibraryDataService.getMvnLib(1)).willReturn(mvnLibPO);
        MvnLibVO mvnLibVO = mvnService.getSpecificMvnLib(1);
        assertEquals(mvnLibVO.getLibId(), 1);
    }

    @Test
    public void extractPomDepsTest() {
        String pom = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
                "    <modelVersion>4.0.0</modelVersion>\n" +
                "    <dependencies>\n" +
                "        <dependency>\n" +
                "            <groupId>org.springframework.boot</groupId>\n" +
                "            <artifactId>spring-boot-starter-data-jdbc</artifactId>\n" +
                "        </dependency>\n" +
                "    </dependencies>\n" +
                "</project>";
        MvnPomAnalyseDTO dto = new MvnPomAnalyseDTO();
        dto.setPom(pom);
        List<MvnLibVO> mvnLibVOS = mvnService.extractPomDeps(dto);
        given(mvnLibraryDataService.getMvnLib("org.springframework.boot", "spring-boot-starter-data-jdbc")).willReturn(mvnLibPO2);
        for (MvnLibVO mvnLibVO : mvnLibVOS) {
            assertTrue(mvnLibVO.getGroupId().contains("org.springframework.boot"));
            assertTrue(mvnLibVO.getArtifactId().contains("spring-boot-starter-data-jdbc"));
        }
    }

    @Test
    public void getMvnProjectTest() {
        given(mvnProjectDataService.getProject(1)).willReturn(mvnProjectPO);
        MvnProjectVO mvnProjectVO = mvnService.getMvnProject(1);
        assertEquals(1, mvnProjectVO.getProjectId());
    }

}