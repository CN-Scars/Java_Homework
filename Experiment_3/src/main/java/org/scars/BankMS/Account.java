package org.scars.BankMS;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("存入" + amount + "元后，您的余额为：" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.printf("余额不足，无法取款");
        } else {
            balance -= amount;
            System.out.println("取款" + amount + "元后，您的余额为：" + balance + "元");
        }
    }
}
