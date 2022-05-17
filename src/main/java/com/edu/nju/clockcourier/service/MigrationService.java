package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.dto.MvnPomAnalyseDTO;
import com.edu.nju.clockcourier.vo.MigInsListVO;
import com.edu.nju.clockcourier.vo.MigrationGraphVO;
import com.edu.nju.clockcourier.vo.MvnLibListVO;

import java.util.List;

public interface MigrationService {

    List<MigrationGraphVO> relativeMigrationGraph(Integer libId);

    MvnLibListVO analysePom(MvnPomAnalyseDTO dto);

    MigInsListVO getInstance(Integer ruleId, Integer page);
}
