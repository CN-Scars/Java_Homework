package org.scars.ProductManageSystem;

import java.util.Date;

public class PurchaseRecord {
    private long id; // 包含时间戳
    private int num; // 进货数量
    private double price; // 价格
    private String name; // 联系人

    public PurchaseRecord(int num, double price, String name) {
        this.id = new Date().getTime();
        this.num = num;
        this.price = price;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PurchaseRecord{" +
                "id=" + id +
                ", num=" + num +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
