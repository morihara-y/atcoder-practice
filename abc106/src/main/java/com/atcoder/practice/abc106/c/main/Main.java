package com.atcoder.practice.abc106.c.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long k = sc.nextLong();
        String[] sArray = s.split("");
        String firstOther = null;
        for (int i = 0; i < k; i++) {
            if (!sArray[i].equals("1")) {
                firstOther = sArray[i];
                break;
            }
        }
        if (firstOther == null) {
            System.out.println(1);
            return;
        }
        System.out.println(firstOther);
    }
}
