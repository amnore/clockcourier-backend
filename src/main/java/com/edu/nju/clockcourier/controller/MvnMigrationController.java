package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/migration/mvn")
public class MvnMigrationController {

    private final MigrationService service;

    @Autowired
    public MvnMigrationController(MigrationService service) {
        this.service = service;
    }

    @GetMapping("/graph/{libId}/get")
    public ResponseVO<List<MigrationNodeVO>> getMvnMigrationGraph(@PathVariable String libId) {
        return ResponseVO.success(this.service.getMigrationGraph(Integer.parseInt(libId)));
    }

    @GetMapping("/rule/{ruleId}/get")
    public ResponseVO<MigrationRuleVO> getRule(@PathVariable Integer ruleId) {
        return ResponseVO.success(null);
    }

    @GetMapping("/rule/{ruleId}/instance/get")
    public ResponseVO<MigrationInstanceListVO> getRuleInstance(@PathVariable Integer ruleId, @RequestParam Integer page) {
        MigrationInstanceListVO migrationInstanceListVO = new MigrationInstanceListVO();
        List<MigrationInstanceVO> migrationInstanceVOS = new ArrayList<>();
        MigrationInstanceVO migrationInstanceVO = new MigrationInstanceVO(1, "project", 1, "file", "www", "first commit", "end commit");
        migrationInstanceVOS.add(migrationInstanceVO);
        migrationInstanceListVO.setCount(1);
        migrationInstanceListVO.setInstances(migrationInstanceVOS);
        return ResponseVO.success(migrationInstanceListVO);
    }

}
