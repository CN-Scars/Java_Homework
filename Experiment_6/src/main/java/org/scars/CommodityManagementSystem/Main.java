package org.scars.CommodityManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        while (true) {
            System.out.println("欢迎使用库房管理系统，请选择要进行的操作：");
            System.out.println("1.商品入库");
            System.out.println("2.商品显示");
            System.out.println("3.删除商品");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manager.addProduct(scanner);
                    break;
                case 2:
                    manager.displayProducts();
                    break;
                case 3:
                    manager.deleteProduct(scanner);
                    break;
                default:
                    System.out.println("无效操作，退出系统！");
            }
        }
    }
}
