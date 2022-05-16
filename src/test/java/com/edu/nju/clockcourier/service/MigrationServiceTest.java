package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dao.MigrationDataService;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.service.impl.MigrationServiceImpl;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class MigrationServiceTest {

    @Mock
    MigrationDataService migrationDataService;

    @Mock
    MvnService mvnService;

    @InjectMocks
    MigrationServiceImpl migrationService;

    private static MigrationRulePO migrationRulePO;

    private static MvnLibVO mvnLibVO_1;

    private static MvnLibVO mvnLibVO_2;

    @BeforeAll
    public static void initData() {
        migrationRulePO = new MigrationRulePO();
        migrationRulePO.setFromId(1);
        migrationRulePO.setToId(2);
        migrationRulePO.setConfidence(1.0);
//        migrationRulePO.setVersion("1.0.0");
//        migrationRulePO.setProjectId(1);

        mvnLibVO_1 = new MvnLibVO();
        mvnLibVO_1.setArtifactId("zzh");
        mvnLibVO_1.setLibId(1);
        mvnLibVO_1.setGroupId("zzh");

        mvnLibVO_2 = new MvnLibVO();
        mvnLibVO_2.setArtifactId("hwd");
        mvnLibVO_2.setLibId(2);
        mvnLibVO_2.setGroupId("hwd");
    }

    @Test
    void relativeMigrationGraphTest() {
        List<MigrationRulePO> rules = new ArrayList<>();
        rules.add(migrationRulePO);

        given(migrationDataService.allRuleWithSpecificStart(1)).willReturn(rules);
        given(mvnService.getSpecificMvnLib(1)).willReturn(mvnLibVO_1);
        given(mvnService.getSpecificMvnLib(2)).willReturn(mvnLibVO_2);
        List<MigrationGraphVO> graphVOS = migrationService.relativeMigrationGraph(1);
        for (MigrationGraphVO vo : graphVOS) {
            assertEquals(1.0, vo.getTransitiveConfidence());
        }
    }

}