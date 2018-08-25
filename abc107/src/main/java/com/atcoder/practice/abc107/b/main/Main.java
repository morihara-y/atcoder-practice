package com.atcoder.practice.abc107.b.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = Integer.parseInt(sc.next());
        int w = Integer.parseInt(sc.next());
        String[][] table = new String[h][w];
        for (int i = 0; i < h; i++) {
            String[] line = sc.next().split("");
            for (int j = 0; j < w; j++) {
                table[i][j] = line[j];
            }
        }
        String rowBreakLine = makeBrankLine(w);
        String columnBreakLine = makeBrankLine(h);
        
        List<Integer> brankRowNums = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < w; j++) {
                sb.append(table[i][j]);
            }
            if (rowBreakLine.equals(sb.toString())) {
                brankRowNums.add(new Integer(i));
            }
        }
        
        List<Integer> brankColumnNums = new ArrayList<>();
        for (int j = 0; j < w; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < h; i++) {
                sb.append(table[i][j]);
            }
            if (columnBreakLine.equals(sb.toString())) {
                brankColumnNums.add(new Integer(j));
            }
        }
        
        for (int i = 0; i < h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < w; j++) {
                if (!isSkip(j, brankColumnNums)) {
                    sb.append(table[i][j]);
                } 
            }
            if (!isSkip(i, brankRowNums)) {
                System.out.println(sb.toString());
            }    
        }
    }

    private static String makeBrankLine(int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sb.append(".");
        }
        return sb.toString();
    }

    private static boolean isSkip(int num, List<Integer> skipNums) {
        for (Integer i : skipNums) {
            if (num == Integer.valueOf(i)) {
                return true;
            }
        }
        return false;
    }
}
