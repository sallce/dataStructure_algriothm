package com.dataStructure_algriothm.practice;

import java.util.HashSet;
import java.util.Set;

public class LuckyEight {

    /**
     * get all numbers which contains number eight and are lower or equal to n
     */
    Set<Integer> validSet = new HashSet();

    public int luckyNumber(int n) {
        int ans = 0;
        // Write your code here
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                validSet.add(i);
                ans++;
            }
        }
        return ans;
    }


    public boolean check(int n) {
        if (validSet.contains(n)) {
            return true;
        }

        int base = 10;

        while(n > 0) {

            if (n%base == 8) {
                return true;
            }

            n = n/base;
        }



        return false;

    }

    public long getMaxValue(int m, int[] v, int[] c) {
        long[][] backpack = new long[c.length+1][m+1];

        for(int i = 1; i <= c.length; i++) {
            for (int j = 0; j <= m; j++) {
                backpack[i][j] = backpack[i-1][j];
                if (j >= c[i-1]) {
                    backpack[i][j] = Math.max(backpack[i][j], backpack[i-1][j-c[i-1]]+v[i-1]);
                }
            }
        }

        return backpack[c.length][m];

    }


    public static void main(String[] args) {
        LuckyEight mySolution = new LuckyEight();

        int ans = mySolution.luckyNumber(1000);

        System.out.println(ans);

//        long ans = mySolution.getMaxValue(10, new int[]{1,5,3}, new int[]{4,5,7});
//
//        System.out.println(ans);
    }

}
