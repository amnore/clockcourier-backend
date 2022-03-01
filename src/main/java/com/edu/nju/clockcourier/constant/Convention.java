package com.edu.nju.clockcourier.constant;

public class Convention {

    public static final String nullStr = "";

    public static boolean isNull(String str) {
        return str == null || str.equals(Convention.nullStr);
    }

}
