package com.dataStructure_algriothm.practice;

import java.util.Arrays;

// First N-1 terms as 0 and N-th term as 1

/**
 * Nth bonacci number;
 * First N-1 terms are 0s and N-th term is 1
 * all other numbers equals to the sum of its N previous numbers
 */
public class Nbonacci {
    public int[] getMnumbers(int n, int m) {
        int[] ans = new int[m];

        Arrays.fill(ans, 0);

        ans[n-1] = 1;
        ans[n] = 1;

        for (int i = n + 1; i < m; i++) {
            ans[i] = ans[i-1] * 2 - ans[i - n - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        Nbonacci nb = new Nbonacci();

        int[] result = nb.getMnumbers(5,15);

        for (int num : result) {
            System.out.println(num);
        }
    }
}
