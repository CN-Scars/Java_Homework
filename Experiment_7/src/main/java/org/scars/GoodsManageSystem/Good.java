package org.scars.GoodsManageSystem;

public class Good {
    int id;
    String name;     //商品的价格
    double price;   //商品的单价
    int number;      //进货的数量
    double money;   //总价
    String people;  //审批人

    public Good(int id, String name, double price, int number, double
            money, String people) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.money = money;
        this.people = people;
    }

    @Override
    public String toString() {
        String message = "进货记录编号：" + id + "\n商品名称：" + name + "" +
                "\n联系人：" + people + "\n单价：" + price + "\n库存数量：" + number + "\n";
        return message;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
