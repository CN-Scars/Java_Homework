package org.scars.CommodityManagementSystem;

class Product implements Comparable<Product> {
    private String name;
    private String color;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return name + "...." +
                color + "...." +
                price + "...." + quantity;
    }

    public Product(String name, String color, double price, int quantity) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Product product) {
        return product.quantity - this.quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
