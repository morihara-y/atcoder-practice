package com.atcoder.practice.abc081.b.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] divisionCntList = makeDivisionCntList(n, sc);
        int maxCnt = Arrays.stream(divisionCntList).min().getAsInt();
        System.out.println(maxCnt);
    }
    
    private static int[] makeDivisionCntList(int n, Scanner sc) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = getDivisionCnt(sc.nextInt());
        }
        return ints;
    }
    
    private static int getDivisionCnt(int i) {
        int cnt = 0;
        while (true) {
            int remainder = i % 2;
            if (remainder == 0) {
                cnt++;
                i = i / 2;
            } else {
                break;
            }
        }
        return cnt;
    }
}
