package com.edu.nju.clockcourier.util;

public class QueryLikeBuilder {

    public static String buildLike(String str) {
        if (str == null || str.equals("")) return null;
        return "%" + str + "%";
    }

}
