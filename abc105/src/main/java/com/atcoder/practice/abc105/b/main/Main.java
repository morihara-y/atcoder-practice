package com.atcoder.practice.abc105.b.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt7 = n / 7;
        int cnt4 = n / 4;
        boolean result = false;
        for (int i = 0; i <= cnt7; i++) {
            for (int j = 0; j <= cnt4; j++) {
                if (i * 7 + j * 4 == n) {
                    result = true;
                }
            }
        }
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
