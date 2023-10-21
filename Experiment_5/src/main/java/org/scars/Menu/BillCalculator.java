package org.scars.Menu;

import java.util.regex.*;

public class BillCalculator {
    public static void main(String[] args) {
        String menu = "糖醋排骨：46元；清蒸鲑鱼：52元；蚂蚁上树：25元；凉拌海蜇头：38元";

        String[] dishes = menu.split("；");

        int totalDishes = dishes.length;
        int totalPrice = 0;

        Pattern pattern = Pattern.compile("(\\d+)元");

        for (String dish : dishes) {
            Matcher matcher = pattern.matcher(dish);
            if (matcher.find()) {
                totalPrice += Integer.parseInt(matcher.group(1));
            }
        }

        System.out.println("总共的菜品数: " + totalDishes);
        System.out.println("总价: " + totalPrice + "元");

        int moneyReceived = 100;
        System.out.println("收到的钱: " + moneyReceived + "元");
        int change = moneyReceived - totalPrice;

        System.out.println("找零: " + change + "元");
    }
}
