package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.vo.MigrationInstanceListVO;
import com.edu.nju.clockcourier.vo.MigrationNodeVO;
import com.edu.nju.clockcourier.vo.MigrationRuleVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/migration/mvn")
public class MigrationController {

    private final MigrationService migrationService;

    @Autowired
    public MigrationController(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @GetMapping("/graph/{libId}/get")
    public ResponseVO<List<MigrationNodeVO>> getMvnMigrationGraph(@PathVariable String libId) {
        return ResponseVO.success(this.migrationService.getMigrationGraph(Integer.parseInt(libId)));
    }

    @GetMapping("/rule/{ruleId}/get")
    public ResponseVO<MigrationRuleVO> getRule(@PathVariable Integer ruleId) {
        return ResponseVO.success(this.migrationService.getRule(ruleId));
    }

    @GetMapping("/rule/{ruleId}/instance/get")
    public ResponseVO<MigrationInstanceListVO> getRuleInstance(@PathVariable Integer ruleId, @RequestParam Integer page) {
        return ResponseVO.success(this.migrationService.getInstance(ruleId, page));
    }

}
