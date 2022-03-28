package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.task.CalcTask;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/migration")
public class MigrationController {

    @Autowired
    private MigrationService service;

    @Autowired
    private CalcTask calcTask;

    @GetMapping("/mvn/lib/{libId}/get")
    public ResponseVO<List<MigrationGraphVO>> getMvnMigrationGraph(@PathVariable String libId) {
        return ResponseVO.success(this.service.relativeMigrationGraph(Integer.parseInt(libId)));
    }

    @PostMapping("/mvn/calc/run")
    public ResponseVO<Void> calcMigration() {
        calcTask.process();
        return ResponseVO.success(null);
    }
}
