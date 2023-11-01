package org.scars.ExamCountDown;

import java.time.LocalDate;
import java.time.Period;

public class ExamCountDown {
    public static void main(String[] args) {
        // 2024年高考时间：2024年6月7日
        LocalDate currentDate = LocalDate.now();
        LocalDate examDate = LocalDate.of(2024, 6, 7);

        // 计算距离2024年高考还剩下多少天
        countDownUsingToEpochDay(currentDate, examDate);    // 使用toEpochDay方法
        countDownUsingPeriod(currentDate, examDate);    // 使用Period类
    }

    private static void countDownUsingPeriod(LocalDate currentDate, LocalDate examDate) {
        Period period = Period.between(currentDate, examDate);    // 计算两个日期之间的差值
        System.out.println("使用Period类，距离2024高考还剩下" + (period.getDays() + period.getMonths() * 30 + period.getYears() * 365) + "天");
    }

    private static void countDownUsingToEpochDay(LocalDate currentDate, LocalDate examDate) {
        long daysBetween = examDate.toEpochDay() - currentDate.toEpochDay();    // 计算天数
        System.out.println("使用toEpochDay方法，距离2024高考还剩下" + daysBetween + "天");
    }
}
