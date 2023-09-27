package org.scars.MobilePhone;

public class MobilePhoneTest {


    public static void main(String[] args) {
        MobilePhone applePhone = new MobilePhone("Apple", "iPhone 15 Pro Max", "iOS", 8888, 8);
        applePhone.displayInfo();
        applePhone.autoDial("爷爷");
        applePhone.playGame("扫雷");
        applePhone.playGame("我的中国心");

        System.out.println("*********************************");

        MobilePhone androidPhone = new MobilePhone("Google", "Pixle 8 Pro", "Android", 5999, 16);
        androidPhone.displayInfo();
        androidPhone.autoDial("奶奶");
        androidPhone.playGame("扫雷");
        androidPhone.playGame("北京欢迎你");
    }
}
