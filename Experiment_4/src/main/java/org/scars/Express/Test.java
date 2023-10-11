package org.scars.Express;

public class Test {
    public static void main(String[] args) {
        SendTask task = new SendTask("HYX600235", 76.34);
        task.sendBefore();

        System.out.println("======================");

        ZTransportation t = new ZTransportation("Z025", "保温冷藏车", "小韩");

        Phone p = new Phone();

        task.send(t, () -> "193, 485");

        System.out.println("======================");
        task.sendAfter(t);
    }
}
