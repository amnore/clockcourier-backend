package com.edu.nju.clockcourier.controller;

import com.edu.nju.clockcourier.service.MigrationService;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/migration")
public class MigrationController {

    private final MigrationService service;

    @Autowired
    public MigrationController(MigrationService service) {
        this.service = service;
    }

    @GetMapping("/mvn/lib/{libId}/get")
    public ResponseVO<MigrationGraphVO> getMvnMigrationGraph(@PathVariable String libId) {
        return ResponseVO.success(this.service.relativeMigrationGraph(Integer.parseInt(libId)));
    }

}
