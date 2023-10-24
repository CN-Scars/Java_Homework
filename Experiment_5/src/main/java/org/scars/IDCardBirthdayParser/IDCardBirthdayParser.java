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

        String birthDayInID = sID.substring(6, 14);

        printBirthDay(birthDayInID);
    }

    private static void printBirthDay(String birthDayInID) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthDate = LocalDate.parse(birthDayInID, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println("出生日期为：" + birthDate.format(outputFormatter));

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();

        System.out.println("年龄为：" + age);
    }
}
