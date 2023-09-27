package org.scars.Sound;

import java.util.Scanner;

public class SampleDisplay {
    public void display(Soundable soundable) {
        soundable.playSound();
        System.out.println("请选择如何调节音量：");
        System.out.println("1-增加 2-降低 3-关闭");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 1) {
            soundable.increaseVolume();
        } else if (choice == 2) {
            soundable.decreaseVolume();
        } else {
            soundable.stopSound();
        }
    }
}
