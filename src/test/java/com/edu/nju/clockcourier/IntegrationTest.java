package com.edu.nju.clockcourier;

import com.edu.nju.clockcourier.constant.MvnLibSortRule;
import com.edu.nju.clockcourier.controller.MigrationController;
import com.edu.nju.clockcourier.controller.MvnLibraryController;
import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.util.PomReader;
import com.edu.nju.clockcourier.vo.MigrationNodeVO;
import com.edu.nju.clockcourier.vo.MigrationRuleVO;
import com.edu.nju.clockcourier.vo.MvnLibListVO;
import com.edu.nju.clockcourier.vo.MvnLibVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class IntegrationTest {

    private final MvnLibraryController mvnLibraryController;
    private final MigrationController migrationController;

    @Autowired
    public IntegrationTest(MvnLibraryController mvnLibraryController,
                           MigrationController migrationController) {
        this.mvnLibraryController = mvnLibraryController;
        this.migrationController = migrationController;
    }

    // id: L6
    @Test
    public void pomAnalyseTest() {
        // 只测试本地 pom
        String root = System.getProperty("user.dir");
        String path = Path.of(root, "pom.xml").toString();
        String content = PomReader.read(path);
        if (content == null) fail();
        MvnPomAnalyseDTO dto = new MvnPomAnalyseDTO();
        dto.setPom(content);
        List<MvnLibVO> list = this.mvnLibraryController.analysePom(dto).getData();
        AtomicBoolean suc = new AtomicBoolean(false);
        list.forEach(e -> {
            suc.set(suc.get() | e.getLibId().equals(113040));
        });
        assertTrue(suc.get());
    }

    private MvnLibFilterDTO buildFilter(String g, String a) {
        MvnLibFilterDTO dto = new MvnLibFilterDTO();
        dto.setSort(MvnLibSortRule.RuleNum);
        dto.setIsReverse(true);
        dto.setStartIndex(0);
        dto.setEndIndex(20);
        dto.setGroupId(g);
        dto.setArtifactId(a);
        return dto;
    }

    private boolean ruleExistsOrNot(String fromG, String fromA, String toG, String toA) {
        // from lib
        MvnLibListVO fromList = this.mvnLibraryController.getMvnLibList(buildFilter(fromG, fromA))
                .getData();
        assertTrue(fromList.getPageAll() >= 1);
        assertTrue(fromList.getLibs().size() > 0);
        MvnLibVO from = fromList.getLibs().get(0);
        // to lib
        MvnLibListVO toList = this.mvnLibraryController.getMvnLibList(buildFilter(toG, toA))
                .getData();
        assertTrue(toList.getPageAll() >= 1);
        assertTrue(toList.getLibs().size() > 0);
        MvnLibVO to = toList.getLibs().get(0);
        // graph
        List<MigrationNodeVO> nodes = this.migrationController
                .getMvnMigrationGraph(String.valueOf(from.getLibId()))
                .getData();
        boolean suc = false;
        for (MigrationNodeVO node : nodes) {
            MvnLibVO v = node.getFromLibInfo();
            if (!Objects.equals(v.getLibId(), from.getLibId())) continue;
            for (MigrationRuleVO rule : node.getEdges()) {
                if (rule.getToId().equals(to.getLibId())) {
                    suc = true;
                    break;
                }
            }
            break;
        }
        return suc;
    }

    // id: L7
    @Test
    public void migrationGraphTest() {
        // test case 1
        String fromG1 = "ant";
        String fromA1 = "ant-junit";
        String toG1 = "org.apache.ant";
        String toA1 = "ant";
        assertTrue(this.ruleExistsOrNot(fromG1, fromA1, toG1, toA1));
        // test case 2
        String fromG2 = "io.zipkin.brave";
        String fromA2 = "brave-okhttp";
        String toG2 = "io.zipkin.brave";
        String toA2 = "brave-instrumentation-okhttp3";
        assertTrue(this.ruleExistsOrNot(fromG2, fromA2, toG2, toA2));
    }

}
