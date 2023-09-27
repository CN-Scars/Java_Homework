package org.scars.MyPrint;

public class MyPrintCircle extends MyPrint {
    @Override
    public void show() {
        for (int y = 0; y <= 2 * 5; y += 2) {
            int x = (int) Math.round(5 - Math.sqrt(2 * 5 * y - y * y));
            int len = 2 * (5 - x);
            for (int i = 0; i <= x; i++) {
                System.out.print(' ');
            }
            System.out.print('*');
            for (int j = 0; j <= len; j++) {
                System.out.print(' ');
            }
            System.out.println('*');
        }
    }
}
