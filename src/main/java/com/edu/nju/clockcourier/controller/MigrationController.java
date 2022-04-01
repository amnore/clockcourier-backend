package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.task.CalcTask;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
