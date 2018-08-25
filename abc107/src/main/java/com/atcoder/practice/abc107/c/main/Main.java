package com.atcoder.practice.abc107.c.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(sc.next());
        }

        int trial = n - k + 1;
        int time = 0;
        int min = Integer.MAX_VALUE;

        if (k == 1) {
            for (int i = 0; i < trial; i++) {
                time = Math.abs(x[i]);
                min = Math.min(min, time);
            }
            System.out.println(min);
            return;
        }

        for (int i = 0; i < trial; i++) {
            int start = x[i];
            int end = x[i + k - 1];
            time = Math.abs(start) + Math.abs(end - start);
            min = Math.min(min, time);
//            time = Math.abs(end) + Math.abs(end - start);
//            min = Math.min(min, time);
        }
        System.out.println(min);
    }
}
