package com.edu.nju.clockcourier.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class PomReader {

    public static String read(String filepath) {
        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filepath));
            String s = null;
            while ((s = bf.readLine()) != null) {
                buffer.append(s.trim());
            }
        } catch (IOException fe) {
            return null;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = Path.of(root, "pom.xml").toString();
        String content = PomReader.read(path);
        System.out.println(content);
    }

}
