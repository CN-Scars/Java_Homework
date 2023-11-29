package org.scars.GoodsManageSystem;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static void saveGoods(Good good) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = dateFormat.format(new Date());
        String fileName = "进货记录" + dateStr + ".csv";

        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(fileName, true), "GBK"); PrintWriter out = new PrintWriter(osw)) {
            // 检查文件是否存在，不存在则写入标题头
            File file = new File(fileName);
            if (!file.exists() || file.length() == 0) {
                out.println("商品编号,商品名称,购买数量,单价,总价,联系人");
            }
            // 写入商品数据
            out.println(good.id + "," + good.name + "," + good.number + "," + good.price + "," + good.money + "," + good.people);
        } catch (IOException e) {
            System.err.println("写入CSV文件时发生错误：" + e.getMessage());
        }
    }
}
