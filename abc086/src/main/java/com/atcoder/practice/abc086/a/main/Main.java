package com.atcoder.practice.abc086.a.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = a * b;
        if (x % 2 != 0) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
