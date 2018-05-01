package com.dataStructure_algriothm.practice;


import java.util.HashSet;
import java.util.Set;

public class CableCar {
    /**
     * @param height: the Cable car station height
     *              the car can only from higher stations to lower stations
     * @return: the longest time that he can ride
     */

    // Write your code here
    int[][] dir = new int[][]{
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
            { 1, 1 },
            { -1, -1 },
            { 1, -1 },
            { -1, 1 }
    };

    public int cableCarRide(int[][] height) {


        if (height == null || height.length == 0)
            return 0;

        int n = height.length;
        int m = height[0].length;
        int best = 0;
        Set<Integer> s = new HashSet();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++){
                best = Math.max(best, countPath(row, col, height, s));
            }
        }

        return best;

    }


    public int countPath(int r, int c, int[][] height, Set<Integer> seen) {
        if(r < 0 || r >= height.length || c <0 || c >= height[0].length || seen.contains(r*height[0].length + c))
            return 0;

        int depth = 1;

        for(int[] d: dir) {
            int r1 = r + d[0];
            int c1 = c + d[1];

            if (r1 < 0 || r1 >= height.length || c1 <0 || c1 >= height[0].length) {
                continue;
            }

            if (height[r][c] < height[r + d[0]][c + d[1]]) {
                seen.add(r*height[0].length + c);
                depth  = Math.max(depth, 1 + countPath(r + d[0], c + d[1], height, seen));
                seen.remove(r*height[0].length + c);
            }

        }

        return depth;
    }

    public static void main(String[] args) {
        CableCar mySolution = new CableCar();

        int ans = mySolution.cableCarRide(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });

        System.out.println(ans);
    }
}