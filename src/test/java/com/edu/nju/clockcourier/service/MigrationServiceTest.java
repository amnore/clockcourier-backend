package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.config.DisplayConfig;
import com.edu.nju.clockcourier.dao.MigrationRuleDataService;
import com.edu.nju.clockcourier.dao.RuleInstanceDataService;
import com.edu.nju.clockcourier.po.MigrationRulePO;
import com.edu.nju.clockcourier.po.RuleInstancePO;
import com.edu.nju.clockcourier.service.impl.MigrationServiceImpl;
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
public class MigrationServiceTest {

    @Mock
    private MvnService mvnService;

    @Mock
    private MigrationRuleDataService migrationRuleDataService;

    @Mock
    private RuleInstanceDataService ruleInstanceDataService;

    @Mock
    private DisplayConfig config;

    @InjectMocks
    private MigrationServiceImpl migrationService;

    private static MigrationRulePO migrationRulePO;

    private static List<MigrationRulePO> migrationRulePOList;

    private static MvnProjectVO mvnProjectVO;

    private static MvnLibVO mvnLibVO;

    private static MvnLibVO mvnLibVO2;

    private static MigrationRuleVO migrationRuleVO;

    private static Pair<List<RuleInstancePO>, Integer> p;

    @BeforeAll
    public static void initData() {
        migrationRulePO = new MigrationRulePO();
        migrationRulePO.setRuleId(1);
        migrationRulePO.setConfidence(1.0);
        migrationRulePO.setFromId(1);
        migrationRulePO.setToId(2);
        migrationRulePO.setApiSup(1.0);
        migrationRulePO.setRuleSup(1.0);
        migrationRulePO.setDisSup(1.0);
        migrationRulePO.setMsgSup(1.0);

        migrationRulePOList = new ArrayList<>();
        migrationRulePOList.add(migrationRulePO);

        RuleInstancePO ruleInstancePO = new RuleInstancePO();
        ruleInstancePO.setRuleId(1);
        ruleInstancePO.setProjectId(1);
        ruleInstancePO.setFileName("filename");
        ruleInstancePO.setStartCommitLink("start");
        ruleInstancePO.setEndCommitLink("end");

        List<RuleInstancePO> ruleInstancePOS = new ArrayList<>();
        ruleInstancePOS.add(ruleInstancePO);

        mvnProjectVO = new MvnProjectVO();
        mvnProjectVO.setProjectId(1);
        mvnProjectVO.setName("name");
        mvnProjectVO.setUrl("url");
        p = Pair.of(ruleInstancePOS, 1);

        mvnLibVO = new MvnLibVO();
        mvnLibVO.setLibId(1);
        mvnLibVO.setGroupId("group");
        mvnLibVO.setArtifactId("artifact");
        mvnLibVO.setDescription("");
        mvnLibVO.setMvnCtrUrl("");
        mvnLibVO.setRepoUrl("");

        mvnLibVO = new MvnLibVO();
        mvnLibVO.setLibId(2);
        mvnLibVO.setGroupId("group2");
        mvnLibVO.setArtifactId("artifact2");
        mvnLibVO.setDescription("");
        mvnLibVO.setMvnCtrUrl("");
        mvnLibVO.setRepoUrl("");
    }

    @Test
    public void getMigrationGraph() {
        given(mvnService.getSpecificMvnLib(1)).willReturn(mvnLibVO);
        given(mvnService.getSpecificMvnLib(2)).willReturn(mvnLibVO2);
        given(migrationRuleDataService.rulesWithSpecificStart(1)).willReturn(migrationRulePOList);
        List<MigrationNodeVO> migrationNodeVOS = migrationService.getMigrationGraph(1);
        for (MigrationNodeVO migrationNodeVO : migrationNodeVOS) {
            assertEquals(1, migrationNodeVO.getFromLibInfo().getLibId());
        }

    }

    @Test
    public void getRule() {
        given(migrationRuleDataService.getRule(1)).willReturn(migrationRulePO);
        MigrationRuleVO migrationRuleVO = migrationService.getRule(1);
        assertEquals(1, migrationRuleVO.getRuleId());
    }

    @Test
    public void getInstanceTest() {
        given(ruleInstanceDataService.getRelativeInstance(1, 1, 15)).willReturn(p);
        given(mvnService.getMvnProject(1)).willReturn(mvnProjectVO);
        given(config.getPageSize()).willReturn("15");
        given(config.pageAll(1)).willReturn(1);
        MigrationInstanceListVO migrationInstanceListVO = migrationService.getInstance(1, 1);
        for (MigrationInstanceVO migrationInstanceVO : migrationInstanceListVO.getInstances()) {
            assertEquals(1, migrationInstanceVO.getRuleId());
        }
        assertEquals(1, migrationInstanceListVO.getPageAll());
    }

}