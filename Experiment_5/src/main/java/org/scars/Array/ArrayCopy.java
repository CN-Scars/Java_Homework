package org.scars.Array;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[10];

        System.arraycopy(a, 2, b, 2, 4);

        for (int i : b) {
            System.out.println(i + " ");
        }
    }
}
