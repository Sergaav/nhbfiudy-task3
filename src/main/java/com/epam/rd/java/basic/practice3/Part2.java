package com.epam.rd.java.basic.practice3;


public class Part2 {
    public static final String FILE_NAME = "C:\\Users\\serga\\IdeaProjects\\nhbfiudy-task3\\part2.txt";

    public static void main(String[] args) {
        System.out.println(convert(Util.getInput(FILE_NAME)));

    }

    public static String convert(String input) {
        String[] words = input.split("[,'\\-\\s]+");
        int minLength = 100;
        int maxLength = 0;
        StringBuilder minElements = new StringBuilder();
        StringBuilder maxElements = new StringBuilder();
        for (String s : words) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        for (String s : words) {
            if (s.length() == minLength && !minElements.toString().contains(s)) {
                minElements.append(s).append(", ");
            }
            if (s.length() == maxLength && !maxElements.toString().contains(s)) {
                maxElements.append(s).append(", ");
            }
        }
        minElements.insert(0, "Min: ");
        maxElements.insert(0, "Max: ");
        return minElements.substring(0, minElements.length() - 2) + "\n" + maxElements.substring(0, maxElements.length() - 2);
    }
}
