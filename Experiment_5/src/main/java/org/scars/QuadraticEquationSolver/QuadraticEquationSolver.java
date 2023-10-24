package org.scars.QuadraticEquationSolver;

import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入二次项系数的值：");
        double a = scanner.nextDouble();
        System.out.println("请输入一次项系数的值：");
        double b = scanner.nextDouble();
        System.out.println("请输入常数项的值：");
        double c = scanner.nextDouble();

        solveQuadraticEquation(a, b, c);
    }

    private static void solveQuadraticEquation(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
        else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("x1 = x2 = " + x);
        }
        else {
            System.out.println("该方程无解！");
        }
    }
}
