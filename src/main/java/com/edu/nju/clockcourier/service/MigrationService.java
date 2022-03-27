package com.edu.nju.clockcourier.service;

import com.edu.nju.clockcourier.vo.MigrationGraphVO;

import java.util.List;

public interface MigrationService {

    List<MigrationGraphVO> relativeMigrationGraph(Integer libId);

}
