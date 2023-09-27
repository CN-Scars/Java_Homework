package org.scars.PayBook;

import org.scars.PayBook.OrderItem;

class Order {
    private String id;
    private OrderItem[] item = new OrderItem[3];
    private double total;

    public Order(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderItem[] getItems() {
        return item;
    }

    public void setItem(OrderItem item, int index) {
        this.item[index] = item;
        this.total += item.getBook().getPrice() * item.getNum();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
