package com.epam.rd.java.basic.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static final String REGEX = "(?iU)(\\w+);(\\w+ \\w+);(\\w+@(\\p{Alpha}+?\\.\\p{Alpha}{2,6}))";
    public static final String FILE_NAME = "C:\\Users\\serga\\IdeaProjects\\nhbfiudy-task3\\part1.txt";

    public static void main(String[] args) {
        System.out.println(convert1(Util.getInput(FILE_NAME)));
        System.out.println(convert2(Util.getInput(FILE_NAME)));
        System.out.println(convert3(Util.getInput(FILE_NAME)));
        System.out.println(convert4(Util.getInput(FILE_NAME)));
    }

    public static String convert1(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            stringBuilder.append(matcher.group(1)).append(": ").append(matcher.group(3)).append("\n");
        }
        stringBuilder.substring(0, stringBuilder.lastIndexOf("\n"));
        return stringBuilder.toString();
    }

    public static String convert2(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String temp = matcher.group(2);
            stringBuilder.append(temp.split(" ")[1].trim()).append(" ").append(temp.split(" ")[0].trim());
            stringBuilder.append(" (email: ").append(matcher.group(3)).append(")\n");
        }
        stringBuilder.substring(0, stringBuilder.lastIndexOf("\n"));
        return stringBuilder.toString();
    }

    public static String convert3(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);

        String domain;
        String user;
        String temp = input;

        while (matcher.find()) {
            domain = matcher.group(4);
            user = matcher.group(1);
            Matcher matcher1 = pattern.matcher(temp);
            boolean flag = false;
            while (matcher1.find()) {
                if (matcher1.group(4).equals(domain) && !matcher1.group(1).equals(user)) {
                    stringBuilder.append(matcher.group(4)).append(" ==> ").append(matcher.group(1));
                    stringBuilder.append(", ").append(matcher1.group(1));
                    flag = true;
                }
            }
            temp = temp.replaceAll(domain, "");
            if (flag) {
                stringBuilder.append("\n");
            }
        }


        return stringBuilder.toString().replace("\n{2,}", "");
    }

    public static String convert4(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        stringBuilder.append(input.split("\r\n")[0]).append(";Password\r\n");
        while (matcher.find()) {
            int pass = Integer.parseInt(String.format("%04d", new SecureRandom().nextInt(1000) * 9 + 1000));
            stringBuilder.append(matcher.group(0)).append(";").append(pass).append("\r\n");
        }

        stringBuilder.substring(0, stringBuilder.lastIndexOf("\r\n"));
        return stringBuilder.toString();
    }
}