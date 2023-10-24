package org.scars.ExamCountDown;

import java.time.LocalDate;
import java.time.Period;

public class ExamCountDown {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate examDate = LocalDate.of(2024, 6, 7);

        countDownUsingToEpochDay(currentDate, examDate);
        countDownUsingPeriod(currentDate, examDate);
    }

    private static void countDownUsingPeriod(LocalDate currentDate, LocalDate examDate) {
        long daysBetween = Period.between(currentDate, examDate).getDays();
        System.out.println("使用Period类，距离2024高考还剩下" + daysBetween + "天");
    }

    private static void countDownUsingToEpochDay(LocalDate currentDate, LocalDate examDate) {
        long daysBetween = examDate.toEpochDay() - currentDate.toEpochDay();
        System.out.println("使用toEpochDay方法，距离2024高考还剩下" + daysBetween + "天");
    }
}
