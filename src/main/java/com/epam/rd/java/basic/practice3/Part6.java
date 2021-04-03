package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    public static final String FILE_NAME = "C:\\Users\\serga\\IdeaProjects\\nhbfiudy-task3\\part6.txt";

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput(FILE_NAME)));
    }

    public static String convert(String input) {
        String output = input;
        Pattern pattern = Pattern.compile("\\b\\w+\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int count = 0;
            for (String s : input.split("\\s")) {
                if (matcher.group(0).equals(s)) {
                    count++;
                }
            }
            if (count > 1) {
                output = output.replaceAll("\\b" + matcher.group(0) + "\\b", "_" + matcher.group(0));
            }
        }
        return output;
    }
}
