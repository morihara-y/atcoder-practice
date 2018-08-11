package com.atcoder.practice.abc105.c.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(getMinusBinary(n));
        }
    }

    private static String getMinusBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (n % -2 == -1) {
                sb.append(1);
                n = n / -2 + 1;
            } else {
                sb.append(n % -2);
                n = n / -2;
            }
            if (n == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
