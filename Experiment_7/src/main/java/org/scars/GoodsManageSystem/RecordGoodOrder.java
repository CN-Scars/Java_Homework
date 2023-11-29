package org.scars.GoodsManageSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordGoodOrder {
    //创建商品库存
    static ArrayList<Good> goodsList = new ArrayList<Good>();

    public static void main(String[] args) {
        init();  //初始化商品库存
        //将书架上所以商品信息打印出来
        for (int i = 0; i < goodsList.size(); i++) {
            System.out.println(goodsList.get(i));
        }
        while (true) {
            //获取控制台输入的信息
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入商品编号");
            int goodId = scan.nextInt();
            Good stockGood = getGoodsById(goodId);
            if (stockGood != null) {// 判断是否存在此商品
                System.out.println("当前商品库存信息" + stockGood);
                System.out.print("请输入进货数量：");
                int goodNumber = scan.nextInt();
                // 将输入信息封装成Good对象
                Good good = new Good(stockGood.id, stockGood.name,
                        stockGood.price, goodNumber, stockGood.price
                        * goodNumber, stockGood.people);
                FileUtil.saveGoods(good);// 将本条数据保存至本地文件
                // 修改库存
                stockGood.setNumber(stockGood.number + goodNumber);
            } else {
                System.out.println("商品编号输入错误！");
            }
        }
    }

    /*
     * 初始化商品库存的信息 将商品存入库存
     */
    private static void init() {
        Good good1 = new Good(1001, "百事可乐", 4.5, 100, 450, "张三");
        Good good2 = new Good(1002, "可口可乐", 4, 100, 400, "李四");
        Good good3 = new Good(1003, "百事雪碧", 3.8, 100, 380, "张三");
        goodsList.add(good1);
        goodsList.add(good2);
        goodsList.add(good3);
    }

    /*
     * 根据输入的商品编号查找商品信息，循环遍历库存中商品信息，找到商品编号相等的取出
     */
    private static Good getGoodsById(int goodId) {
        for (int i = 0; i < goodsList.size(); i++) {
            Good thisGood = goodsList.get(i);
            if (goodId == thisGood.id) {
                return thisGood;
            }
        }
        return null;
    }
}
