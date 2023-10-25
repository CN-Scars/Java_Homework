package org.scars.CompoundInterestCaculatorWithREX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompoundInterestCaculatorWithREX {
    public static void main(String[] args) {
        String input = "存款的数据num=\"352140\",年利率p=\"0.02\",年year=\"3\"";
        Pattern pattern = Pattern.compile("num=\"(\\d+)\",年利率p=\"(\\d+\\.?\\d*)\",年year=\"(\\d+)\"");
        Matcher matcher = pattern.matcher(input);
        String num, p, year;
        if (matcher.find()) {
            num = matcher.group(1);
            p = matcher.group(2);
            year = matcher.group(3);

            double principal = Double.parseDouble(num);
            double rate = Double.parseDouble(p);
            double time = Double.parseDouble(year);

            double amount = caculateCompoundInterest(principal, rate, time);
            System.out.printf("应取出的钱为：%.2f", amount);
        } else {
            System.out.println("输入格式不合法！");
        }
    }

    private static double caculateCompoundInterest(double principal, double rate, double time) {
        return principal * Math.pow((1 + rate), time);
    }
}
