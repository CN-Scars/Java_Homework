package org.scars.CommodityManagementSystem;

import java.util.*;

public class InventoryManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Scanner scanner) {
        System.out.println("您是否录入商品？");
        String input = scanner.next();
        if ("yes".equalsIgnoreCase(input)) {
            System.out.println("请输入商品的名称：");
            String name = scanner.nextLine();
            scanner.nextLine();
            System.out.println("请输入商品的颜色：");
            String color = scanner.nextLine();
            System.out.println("请输入商品的价格：");
            double price = scanner.nextDouble();
            System.out.println("请输入商品的数量：");
            int quantity = scanner.nextInt();

            Product product = new Product(name, color, price, quantity);
            products.add(product);
            System.out.println("商品入库成功，入库后仓库商品如下：");
            displayProducts();
        }
//        scanner.close();
    }

    public void displayProducts() {
        Collections.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void deleteProduct(Scanner scanner) {
        System.out.println("请输入你要删除的商品编号：");
        int index  = scanner.nextInt();
        if (index >= 1 && index <= products.size()){
            products.remove(index - 1);
            System.out.println("商品出库成功，出库后仓库商品如下：");
            displayProducts();
        }
        else {
            System.out.println("无效的商品编号！");
        }
    }
}
