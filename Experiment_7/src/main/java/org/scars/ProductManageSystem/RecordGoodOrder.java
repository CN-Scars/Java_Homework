package org.scars.ProductManageSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RecordGoodOrder {
    // 商品库存列表
    static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        // 从CSV文件加载商品库存
        productList = FileUtil.loadProducts("products.csv");

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入操作选项：1. 进货 2. 查看库存 3. 查看总费用 0. 退出");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("请输入商品编号:");
                    int goodId = scan.nextInt();
                    Product product = getProductById(goodId);
                    if (product != null) {
                        System.out.println("当前商品库存信息：" + product);
                        System.out.print("请输入进货数量：");
                        int amount = scan.nextInt();
                        // 假设进货单价与商品单价相同
                        double price = product.getPrice();
                        System.out.print("请输入联系人：");
                        scan.nextLine(); // 清除换行符
                        String contact = scan.nextLine();
                        PurchaseRecord record = new PurchaseRecord(amount, price, contact);
                        FileUtil.savePurchaseRecord("purchase_records.csv", record);
                        // 更新库存数量
                        product.setStock(product.getStock() + amount);
                        // 打印确认信息
                        System.out.println("进货记录已添加.");
                    } else {
                        System.out.println("商品编号输入错误！");
                    }
                    break;
                case 2:
                    System.out.println("请选择排序方式：1. 库存量升序 2. 库存量降序");
                    int stockSortOption = scan.nextInt();
                    if (stockSortOption == 1) {
                        Collections.sort(productList, Comparator.comparingInt(Product::getStock)); // 库存量升序
                    } else {
                        Collections.sort(productList, (p1, p2) -> p2.getStock() - p1.getStock()); // 库存量降序
                    }
                    for (Product p : productList) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.println("请选择排序方式：1. 总费用升序 2. 总费用降序");
                    int costSortOption = scan.nextInt();
                    productList.stream().sorted((p1, p2) -> {
                        double totalCost1 = p1.getStock() * p1.getPrice();
                        double totalCost2 = p2.getStock() * p2.getPrice();
                        return costSortOption == 1 ? Double.compare(totalCost1, totalCost2) : Double.compare(totalCost2, totalCost1);
                    }).forEach(p -> {
                        double totalCost = p.getStock() * p.getPrice();
                        System.out.println(p + " 总费用: " + totalCost);
                    });
                    break;

                case 0:
                    return; // 退出程序
                default:
                    System.out.println("无效的操作选项！");
                    break;
            }
        }
    }

    private static Product getProductById(int goodId) {
        for (Product product : productList) {
            if (product.getId() == goodId) {
                return product;
            }
        }
        return null;
    }
}
