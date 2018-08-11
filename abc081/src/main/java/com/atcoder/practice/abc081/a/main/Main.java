package com.atcoder.practice.abc081.a.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] strs = str.split("");
        int cnt = 0;
        for (String s : strs) {
            if (s.equals("1")) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
