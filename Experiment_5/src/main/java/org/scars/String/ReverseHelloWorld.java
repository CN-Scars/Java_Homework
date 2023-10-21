package org.scars.String;

public class ReverseHelloWorld {
    public static void main(String[] args) {
        String s = "Hello World";

        StringBuffer buffer = new StringBuffer();

        for (int i = s.length() - 1;
             i >= 0; --i) {
            char currentChar = s.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                currentChar = Character.toLowerCase(currentChar);
            } else {
                currentChar = Character.toUpperCase(currentChar);
            }

            buffer.append(currentChar);
        }

        System.out.println(buffer.toString());
    }
}
