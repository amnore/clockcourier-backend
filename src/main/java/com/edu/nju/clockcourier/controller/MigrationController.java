package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.task.CalcTask;
import com.edu.nju.clockcourier.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/migration")
public class MigrationController {

    private final MigrationService service;

    private final CalcTask calcTask;

    @Autowired
    public MigrationController(MigrationService service, CalcTask calcTask) {
        this.service = service;
        this.calcTask = calcTask;
    }

    @GetMapping("/mvn/lib/{libId}/get")
    public ResponseVO<List<MigrationGraphVO>> getMvnMigrationGraph(@PathVariable String libId) {
        return ResponseVO.success(this.service.relativeMigrationGraph(Integer.parseInt(libId)));
    }

    @PostMapping("/mvn/calc/run")
    public ResponseVO<Void> reCalcMigration() {
        calcTask.process();
        return ResponseVO.success(null);
    }

    @PostMapping("/mvn/pom/analyse")
    public ResponseVO<MvnLibListVO> analysePom(@RequestBody MvnPomAnalyseDTO dto) {
        MvnLibListVO mvnLibListVO = new MvnLibListVO();
        mvnLibListVO.setCount(2);
        MvnLibVO mvnLibVO1 = new MvnLibVO(1, "groupId:lib1", "ArtifactId:lib1");
        MvnLibVO mvnLibVO2 = new MvnLibVO(2, "groupId:lib2", "ArtifactId:lib2");
        List<MvnLibVO> mvnLibVOS = new ArrayList<>();
        mvnLibVOS.add(mvnLibVO1);
        mvnLibVOS.add(mvnLibVO2);
        mvnLibListVO.setLibs(mvnLibVOS);
        return ResponseVO.success(mvnLibListVO);
    }

    @GetMapping("/mvn/rule/{ruleId}/instance/get")
    public ResponseVO<MigInsListVO> getInstance(@PathVariable String ruleId, @RequestParam Integer page) {
        MigInsListVO migInsListVO = new MigInsListVO();
        List<MigrationInstanceVO> migrationInstanceVOS = new ArrayList<>();
        MigrationInstanceVO migrationInstanceVO = new MigrationInstanceVO(1, "project", 1, "file", "www", "first commit", "end commit");
        migrationInstanceVOS.add(migrationInstanceVO);
        migInsListVO.setCount(1);
        migInsListVO.setInstances(migrationInstanceVOS);
        return ResponseVO.success(migInsListVO);

    }
}
