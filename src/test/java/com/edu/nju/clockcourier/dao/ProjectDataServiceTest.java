package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.config.DatabaseConfig;
import com.edu.nju.clockcourier.constant.ProjSortRule;
import com.edu.nju.clockcourier.dto.ProjFilterDTO;
import com.edu.nju.clockcourier.po.ProjectPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ProjectDataServiceTest {

    private final ProjectDataService projectDataService;
    private final DatabaseConfig config;

    @Autowired
    public ProjectDataServiceTest(ProjectDataService projectDataService,
                                  DatabaseConfig config) {
        this.projectDataService = projectDataService;
        this.config = config;
    }

    @Test
    void getProjectTest() throws ParseException {
        ProjectPO po = projectDataService.getProject(31613);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date expected = ft.parse("2015-01-21 12:25:46");
        Date actual = po.getCreateTimestamp();
        assertEquals(expected.getTime(), actual.getTime());
    }

    @Test
    void allAndFilterTest() {
        ProjFilterDTO dto = new ProjFilterDTO();
        dto.setSort(ProjSortRule.CreateT);
        dto.setLanguage("PHP");
        dto.setIsReverse(true);
        dto.setDependency("ath");
        dto.setPage(1);
        int pageSize = Integer.parseInt(config.getPageSize());
        Pair<List<ProjectPO>, Integer> p = projectDataService.allAndFilter(dto, pageSize);
        List<ProjectPO> res1 = p.getFirst();
        assertFalse(res1.isEmpty());
        for (ProjectPO cur : res1) {
            assertEquals("PHP", cur.getLanguage());
        }
    }

}