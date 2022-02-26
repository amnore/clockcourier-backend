package com.edu.nju.clockcourier.util;

public class QueryLikeBuilder {

    public static String buildLike(String str) {
        if (str == null) return null;
        return "%" + str + "%";
    }

}
