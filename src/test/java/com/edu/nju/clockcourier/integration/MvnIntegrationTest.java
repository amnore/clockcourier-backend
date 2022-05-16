package com.edu.nju.clockcourier.integration;

import com.edu.nju.clockcourier.constant.Convention;
import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.constant.MvnProjSortRule;
import com.edu.nju.clockcourier.controller.MvnController;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import com.edu.nju.clockcourier.util.Sorter;
import com.edu.nju.clockcourier.vo.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MvnIntegrationTest {

    private final MvnController mvnController;

    @Autowired
    public MvnIntegrationTest(MvnController mvnController) {
        this.mvnController = mvnController;
    }

    // L3-1
    @Test
    @Disabled
    public void queryMvnDepsTest() {
        // L3-1.1
        String artifactId = "specs2-core";
        MvnLibFilterDTO dto = new MvnLibFilterDTO();
        dto.setStartIndex(0);
        dto.setEndIndex(20);
        dto.setIsReverse(false);
        dto.setSort(MvnLibSortRule.GroupId);
        dto.setArtifactId(artifactId);
        MvnLibListVO list1 = this.mvnController.getMvnLibList(dto).getData();
        assertNotNull(list1);
        assertTrue(list1.getLibs().size() > 0);
        for (MvnLibVO vo : list1.getLibs()) {
            assertTrue(vo.getArtifactId().contains(artifactId));
        }
        // L3-1.2
        artifactId = "specs2";
        String groupId = "org.specs2";
        dto.setArtifactId(artifactId);
        dto.setGroupId(groupId);
        MvnLibListVO list2 = this.mvnController.getMvnLibList(dto).getData();
        assertNotNull(list2);
        assertTrue(list2.getLibs().size() > 0);
        for (MvnLibVO vo : list2.getLibs()) {
            assertTrue(vo.getArtifactId().contains(artifactId));
            assertTrue(vo.getGroupId().contains(groupId));
        }
    }

    // id: L4-1, L4-2
    @Test
    @Disabled
    public void getMvnProjTest() {
        // L4-1.1
        // dto init
        String artifactId = "spring";
        MvnProjFilterDTO dto = new MvnProjFilterDTO();
        dto.setStartIndex(0);
        dto.setEndIndex(15);
        dto.setSort(MvnProjSortRule.GroupId);
        dto.setIsReverse(false);
        dto.setArtifactId(artifactId);
        // get mvn proj
        MvnProjListVO list1 = this.mvnController.getMvnProjList(dto).getData();
        assertNotNull(list1);
        assertNotNull(list1.getProjects());
        assertTrue(list1.getProjects().size() > 0);
        // 测试所有项目的 artifact_id
        for (MvnNewestProjVO vo : list1.getProjects()) {
            assertTrue(vo.getArtifactId().contains(artifactId));
        }
        // L4-1.2
        String groupId = "social";
        dto.setGroupId(groupId);
        MvnProjListVO list2 = this.mvnController.getMvnProjList(dto).getData();
        assertNotNull(list2);
        assertNotNull(list2.getProjects());
        assertTrue(list2.getProjects().size() > 0);
        // 测试所有项目的 artifact_id group_id
        for (MvnNewestProjVO vo : list2.getProjects()) {
            assertTrue(vo.getArtifactId().contains(artifactId));
            assertTrue(vo.getGroupId().contains(groupId));
        }
        // L4-2
        dto.setGroupId(Convention.nullStr);
        dto.setSort(MvnProjSortRule.ArtifactId);
        MvnProjListVO list3 = this.mvnController.getMvnProjList(dto).getData();
        assertNotNull(list3);
        List<MvnNewestProjVO> pros = list3.getProjects();
        assertNotNull(pros);
        assertTrue(pros.size() > 0);
        assertTrue(pros.get(0).getArtifactId().contains(artifactId));
        // 测试所有项目的 artifact_id 以及顺序
        for (int i = 1; i < pros.size(); ++i) {
            MvnNewestProjVO pre = pros.get(i - 1);
            MvnNewestProjVO cur = pros.get(i);
            assertTrue(cur.getArtifactId().contains(artifactId));
            assertTrue(Sorter.DictCompare(pre.getArtifactId(), cur.getArtifactId()) < 0);
        }
    }

    // id: L5-1
    @Test
    @Disabled
    public void getMvnDepsTest() {
        String target = "bb4-hiq";
        MvnProjFilterDTO dto = new MvnProjFilterDTO();
        dto.setStartIndex(0);
        dto.setEndIndex(15);
        dto.setSort(MvnProjSortRule.GroupId);
        dto.setIsReverse(false);
        dto.setArtifactId(target);
        // 通过 mvn 项目名称搜索项目
        MvnProjListVO list = this.mvnController.getMvnProjList(dto).getData();
        assertNotNull(list);
        assertNotNull(list.getProjects());
        assertTrue(list.getProjects().size() > 0);
        // 得到项目
        MvnNewestProjVO vo = list.getProjects().get(0);
        assertEquals(vo.getArtifactId(), target);
        // 获取最早的版本
        String version = vo.getVersions().get(0);
        assertEquals("1.1.2", version);
        // 获取最早版本的依赖情况
        MvnProjVO proj = this.mvnController
                .getSpecificMvnProj(String.valueOf(vo.getProjectId()), version)
                .getData();
        assertNotNull(proj);
        assertTrue(proj.getDependencies().size() > 0);
    }

    // id: L5-2
    @Test
    @Disabled
    public void getMvnProjWithSpecificVersionTest() {
        // 项目 id, 已经获取好的
        int id = 4919;
        MvnProjVO proj1 = this.mvnController
                .getSpecificMvnProj(String.valueOf(id), "1.1.2")
                .getData();
        assertNotNull(proj1);
        List<MvnDepVO> deps1 = proj1.getDependencies();
        assertTrue(deps1.size() > 0);
        // 测试第一个版本数据正确性
        boolean flag1 = false;
        for (MvnDepVO cur : deps1) {
            if (!cur.getArtifactId().equals("junit")) continue;
            if (cur.getVersion().equals("3.+")) {
                flag1 = true;
                break;
            }
        }
        assertTrue(flag1);
        MvnProjVO proj2 = this.mvnController
                .getSpecificMvnProj(String.valueOf(id), "1.3")
                .getData();
        assertNotNull(proj2);
        List<MvnDepVO> deps2 = proj2.getDependencies();
        assertTrue(deps2.size() > 0);
        // 测试第二个版本数据正确性
        boolean flag2 = false;
        for (MvnDepVO cur : deps2) {
            if (!cur.getArtifactId().equals("junit")) continue;
            if (cur.getVersion().equals("4.11")) {
                flag2 = true;
                break;
            }
        }
        assertTrue(flag2);
    }

}
