package com.edu.nju.clockcourier.util;

import com.edu.nju.clockcourier.constant.Convention;
import org.mybatis.dynamic.sql.SortSpecification;

public class QueryBuilder {

    public static String buildLike(String str) {
        if (str == null || str.equals(Convention.nullStr)) return null;
        return "%" + str + "%";
    }

    public static SortSpecification buildReverse(SortSpecification sort, boolean isDesc) {
        return (isDesc) ? sort.descending() : sort;
    }

}
