package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static final String FILE_NAME = "C:\\Users\\serga\\IdeaProjects\\nhbfiudy-task3\\part3.txt";

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput(FILE_NAME)));

    }

    public static String convert(String input) {

        StringBuilder sb = new StringBuilder(input);
        Pattern p = Pattern.compile("\\b\\p{L}{3}");
        Matcher m = p.matcher(input);
        while (m.find()) {
            char firstChar = sb.charAt(m.start());
            if (Character.isUpperCase(firstChar)) {
                sb.setCharAt(m.start(), Character.toLowerCase(firstChar));
            } else {
                sb.setCharAt(m.start(), Character.toUpperCase(firstChar));
            }
        }
        return sb.toString();
    }
}
