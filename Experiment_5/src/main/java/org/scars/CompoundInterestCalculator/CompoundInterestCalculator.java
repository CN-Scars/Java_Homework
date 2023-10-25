package org.scars.CompoundInterestCalculator;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        // 本金、利率、存款年限
        String num = "352140";
        String p = "0.02";
        String year = "3";

        // 将字符串转换为数值
        double principal = Double.parseDouble(num);
        double rate = Double.parseDouble(p);
        Integer time = Integer.parseInt(year);

        //  计算复利
        double amount = calculateCompoundInterest(principal, rate, time);
        System.out.printf("应取出的钱为：%.2f\n", amount);
    }

    private static double calculateCompoundInterest(double principal, double rate, Integer time) {
        return principal * Math.pow((1 + rate), time);  // 复利公式为：本金 * (1 + 利率) ^ 存款年限
    }
}
