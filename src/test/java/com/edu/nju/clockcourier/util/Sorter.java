package com.edu.nju.clockcourier.util;

public class Sorter {

    private static int compareOnce(char ca, char cb) {
        return ca - cb;
    }

    // <  0: a <  b
    // == 0: a == b
    // >  0: a >  b
    public static int DictCompare(String a, String b) {
        int la = a.length();
        int lb = b.length();
        for (int i = 0; i < Math.min(la, lb); ++i) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            int cur = compareOnce(ca, cb);
            if (cur != 0) return cur;
        }
        return Integer.compare(la, lb);
    }

}
