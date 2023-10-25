package org.scars.IDCardBirthdayParser;

import java.time.Period;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IDCardBirthdayParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入身份证号码：");
        String sID = scanner.nextLine();

        // 从身份证号码中截取出生日期
        String birthDayInID = sID.substring(6, 14);

        printBirthDay(birthDayInID);    // 打印出生日期
    }

    private static void printBirthDay(String birthDayInID) {
        // 将出生日期字符串转换为LocalDate对象
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // 日期格式化对象
        LocalDate birthDate = LocalDate.parse(birthDayInID, inputFormatter);    // 解析出生日期字符串

        // 将LocalDate对象格式化为指定格式的字符串
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日"); // 日期格式化对象
        System.out.println("出生日期为：" + birthDate.format(outputFormatter));   // 格式化出生日期

        // 计算年龄
        LocalDate currentDate = LocalDate.now();    // 获取当前日期
        int age = Period.between(birthDate, currentDate).getYears();    // 计算年龄

        System.out.println("年龄为：" + age);
    }
}
