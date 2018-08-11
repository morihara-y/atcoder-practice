package com.atcoder.practice.abc083.b.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            if (a <= sum && sum <= b) {
                result = result + i;
            }
        }
        
        System.out.println(result);
    }
    
    private static int getSum(int n) {
        String[] nums = String.valueOf(n).split("");
        int sum = 0;
        for (String num : nums) {
            sum = sum + Integer.parseInt(num);
        }
        return sum;
    }
}
