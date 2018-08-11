package com.atcoder.practice.abc087.b.main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> aList = getAList(n, sc);
        int alice = 0;
        int bob = 0;
        int cnt = getLoopCnt(aList.size());
        
        for (int i = 0; i < cnt; i++) {
            alice = alice + getMaxValueAndRemove(aList);
            bob = bob + getMaxValueAndRemove(aList);
        }
        
        System.out.println(alice - bob);
    }
    
    private static int getLoopCnt(int listSize) {
        int cnt = listSize / 2;
        if (listSize % 2 == 1) {
            cnt = cnt + 1;
        }
        return cnt;
    }
    
    private static List<Integer> getAList (int n, Scanner sc) {
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aList.add(sc.nextInt());
        }
        return aList;
    }
    
    private static int getMaxValueAndRemove(List<Integer> list) {
        if (list.size() >= 2) {
            int result = Collections.max(list);
            int index = list.indexOf(result);
            list.remove(index);
            return result;
        }
        return list.get(0);
    }
}
