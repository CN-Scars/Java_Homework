package org.scars.Express;

public abstract class Transportation {
    private String model;
    private String admin;
    private String number;

    public Transportation(String model, String admin, String number) {
        this.model = model;
        this.admin = admin;
        this.number = number;
    }

//    public Transportation() {
//
//    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    void transport() {
        System.out.println("运输中");
    }
}
