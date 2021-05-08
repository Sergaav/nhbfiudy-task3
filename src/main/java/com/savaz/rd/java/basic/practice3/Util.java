package com.savaz.rd.java.basic.practice3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Util {
    private Util() {
    }

    public static String getInput(String fileName) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            res = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(getInput("part1.txt"));

    }

}