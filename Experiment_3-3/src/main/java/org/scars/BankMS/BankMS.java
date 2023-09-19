package org.scars.BankMS;

import java.util.Scanner;

public class BankMS {
    public static void main(String[] args) {
        System.out.println("请选择操作：");
        System.out.println("1.存款");
        System.out.println("2.取款");
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        Account ba = new Account("123456", 5000);
        if (op == 1) {
            System.out.println("请输入存款金额：");
            int amount = sc.nextInt();
            ba.deposit(amount);
        } else {
            System.out.println("请输入取款金额：");
            int amount = sc.nextInt();
            ba.withdraw(amount);
        }
    }
}
