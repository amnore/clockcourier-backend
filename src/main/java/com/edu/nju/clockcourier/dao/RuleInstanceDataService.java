package com.edu.nju.clockcourier.dao;

import com.edu.nju.clockcourier.po.RuleInstancePO;
import org.springframework.data.util.Pair;

import java.util.List;

public interface RuleInstanceDataService {
    
    Pair<List<RuleInstancePO>, Integer> getRelativeInstance(Integer ruleId, Integer pageNum, Integer pageSize);

}
