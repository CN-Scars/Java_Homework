package org.scars.ProductManageSystem;

public class Product {
    private int id;
    private String goodName;
    private int stock; // 库存
    private double price; // 单价

    public Product(int id, String goodName, int stock, double price) {
        this.id = id;
        this.goodName = goodName;
        this.stock = stock;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }

    // 计算并返回总费用
    public double getTotalCost() {
        return stock * price;
    }
}
