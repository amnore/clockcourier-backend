package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.constant.MvnProjSortRule;
import com.edu.nju.clockcourier.dto.MvnProjFilterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MvnProjServiceTest {

    @Autowired
    private MvnProjService mvnProjService;

    @Test
    void query() {
        MvnProjFilterDTO filterDTO = new MvnProjFilterDTO();
        filterDTO.setIsReverse(false);
        filterDTO.setStartIndex(1);
        filterDTO.setEndIndex(1);
        filterDTO.setSort(MvnProjSortRule.ArtifactId);
        System.out.println(mvnProjService.query(filterDTO));
    }

    @Test
    void getMvn() {
        System.out.println(mvnProjService.getMvn(1, "3.4.1"));
    }

    @Test
    void getBase() {
        System.out.println(mvnProjService.getBase(1));
    }
}