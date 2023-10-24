package org.scars.RandomNumbers;

import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 1; i <= 100; ++i) {
            int number = random.nextInt(66) + 30;
            System.out.printf("%d(五次方：%.0f) %s", number, Math.pow(number, 5), (i % 5 == 0) ? "\n" : "");
        }
    }
}
