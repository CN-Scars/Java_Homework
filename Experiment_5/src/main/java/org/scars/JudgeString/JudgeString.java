package org.scars.JudgeString;

import java.util.Scanner;
import java.util.regex.Pattern;

public class JudgeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");

        String input = scanner.nextLine();

        if (isValidString(input)) {
            System.out.println("该字符串是合法字符串");
        } else {
            System.out.println("该字符串不是合法字符串");
        }
    }

    private static boolean isValidString(String input) {
        return Pattern.matches("^[a-zA-Z_$][a-zA-Z0-9_$]*", input);
    }
}
