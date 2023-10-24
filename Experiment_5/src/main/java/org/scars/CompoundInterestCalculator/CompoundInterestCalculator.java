package org.scars.CompoundInterestCalculator;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        String num = "352140";
        String p = "0.02";
        String year = "3";

        double principal = Double.parseDouble(num);
        double rate = Double.parseDouble(p);
        Integer time = Integer.parseInt(year);

        double amount = calculateCompoundInterest(principal, rate, time);
        System.out.printf("应取出的钱为：%.2f\n", amount);
    }

    private static double calculateCompoundInterest(double principal, double rate, Integer time) {
        return principal * Math.pow((1 + rate), time);
    }
}
