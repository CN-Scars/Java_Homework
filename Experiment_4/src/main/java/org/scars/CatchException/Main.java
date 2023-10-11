package org.scars.CatchException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int x, n, a[] = {1, 2, 3, 4, 5};
            n = sc.nextInt();
            x = a[n] / n;
            System.out.println("x=" + x);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("发生异常" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
