package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.dto.MvnLibFilterDTO;
import com.edu.nju.clockcourier.po.MvnLibPO;
import org.springframework.data.util.Pair;

import java.util.List;

public interface MvnLibraryDataService {

    void insertMvnLib(MvnLibPO po);

    MvnLibPO getMvnLib(String groupId, String artifactId);

    MvnLibPO getMvnLib(Integer libId);

    Pair<List<MvnLibPO>, Integer> allMvnLibAndFilter(MvnLibFilterDTO filter);

    List<Integer> allMvnLibId();

    void updateStartRuleNum(Integer libId, Integer num);

}
