package com.practice.meta;

public class RandomTest {


    public static void main(String arr[]) {
        String s = "140";
        int n = s.length();
        long num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c);
                System.out.println("c "+c);
                System.out.println("num "+num);
            }
        }
        System.out.println("num "+num);

    }
}
