package org.scars.Express;

public class ZTransportation extends Transportation {
    String model;
    String admin;
    String number;

    public ZTransportation(String model, String admin, String number, String model1, String admin1, String number1) {
        super(model, admin, number);
        this.model = model1;
        this.admin = admin1;
        this.number = number1;
    }

    public ZTransportation(String model, String admin, String number) {
        super(model, admin, number);
        this.model = model;
        this.admin = admin;
        this.number = number;
    }

//    public ZTransportation() {
//        super();
//    }

    void transport() {
        System.out.println("运输中");
    }
}
