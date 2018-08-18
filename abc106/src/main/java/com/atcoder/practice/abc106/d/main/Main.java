package com.atcoder.practice.abc106.d.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nUp = Integer.parseInt(sc.next());
        int mUp = Integer.parseInt(sc.next());
        int qUp = Integer.parseInt(sc.next());
        int[][] lrArray = makeArray(mUp, sc);
        int[][] pqArray = makeArray(qUp, sc);
        for (int i = 0; i < qUp; i++) {
            int p = pqArray[i][0];
            int q = pqArray[i][1];
            int result = 0;
            for (int j = 0; j < mUp; j++) {
                int l = lrArray[j][0];
                int r = lrArray[j][1];
                if (p <= l && r <= q) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static int[][] makeArray(int max, Scanner sc) {
        int[][] array = new int[max][2];
        for (int i = 0; i < max; i++) {
            array[i][0] = Integer.parseInt(sc.next());
            array[i][1] = Integer.parseInt(sc.next());
        }
        return array;
    }
}
