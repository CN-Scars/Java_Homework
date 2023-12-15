package org.scars.TortoiseAndHare;

import java.util.Random;

public class Race {
    private int toristDistance = 0; // 乌龟跑过的距离
    private int rabbitDistance = 0; // 兔子跑过的距离

    // 乌龟线程内部类
    class Torist extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 800; i++) {
                if (rabbitDistance >= 800) {
                    System.out.println("兔子赢得了比赛, 此时乌龟才跑了" + toristDistance + "米");
                    break;
                } else {
                    toristDistance += 1;
                    if (toristDistance % 100 == 0) {
                        try {
                            if (rabbitDistance < 600) {
                                System.out.println("乌龟跑了" + toristDistance + "米, 此时兔子在睡觉");
                            } else {
                                System.out.println("乌龟跑了" + toristDistance + "米, 此时兔子过的距离是" + rabbitDistance + "米");
                            }
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (toristDistance >= 800) {
                System.out.println("乌龟赢得了比赛, 此时兔子跑了" + rabbitDistance + "米");
            }
        }
    }

    // 兔子线程内部类
    class Rabbit extends Thread {
        @Override
        public void run() {
            Random rand = new Random();
            for (int i = 1; i <= 800 / 5; i++) {
                rabbitDistance += 5;
                if (toristDistance >= 800) {
                    System.out.println("乌龟赢得了比赛, 此时兔子跑了" + rabbitDistance + "米");
                    break;
                } else if (rabbitDistance % 100 == 0) {
                    if (rand.nextBoolean()) {
                        System.out.println("兔子跑了" + rabbitDistance + "米, 决定休息一会");
                        try {
                            Thread.sleep(120000); // 休息两分钟
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("兔子跑了" + rabbitDistance + "米, 决定继续跑");
                    }
                }
            }
            if (rabbitDistance >= 800) {
                System.out.println("兔子赢得了比赛, 此时乌龟跑了" + toristDistance + "米");
            }
        }
    }

    // 测试主函数
    public static void main(String[] args) {
        Race race = new Race();
        Torist torist = race.new Torist();
        Rabbit rabbit = race.new Rabbit();

        rabbit.start();
        torist.start();
    }
}

