package com.edu.nju.clockcourier.util;

import com.edu.nju.clockcourier.constant.Convention;
import org.mybatis.dynamic.sql.SortSpecification;

public class QueryBuilder {

    public static String buildLike(String str) {
        if (Convention.isNull(str)) return null;
        return "%" + str + "%";
    }

    public static SortSpecification buildReverse(SortSpecification sortRule, boolean isDesc) {
        return (isDesc) ? sortRule.descending() : sortRule;
    }

}
