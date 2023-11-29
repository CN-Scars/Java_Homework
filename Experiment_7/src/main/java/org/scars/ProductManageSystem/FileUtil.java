package org.scars.ProductManageSystem;

import org.scars.GoodsManageSystem.Good;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileUtil {
    // 读取商品信息CSV文件
    public static ArrayList<Product> loadProducts(String filePath) {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; // 用于跳过标题行的标志
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 跳过第一行（标题行）
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String goodName = data[1].trim();
                int stock = Integer.parseInt(data[2].trim());
                double price = Double.parseDouble(data[3].trim()); // 添加对单价的读取
                products.add(new Product(id, goodName, stock, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    // 保存进货记录到CSV文件
    public static void savePurchaseRecord(String filePath, PurchaseRecord record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(record.getId() + "," + record.getNum() + "," + record.getPrice() + "," + record.getName());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
