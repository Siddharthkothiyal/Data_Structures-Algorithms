package DynamicProgramming;

import java.util.Arrays;

public class uniquepaths {

    public static int helper(int m, int n, int i, int j, int[][] dp) {

        if (i == 0 && j == 0) {
            return 1;
        }

        if(i<0 || j<0) return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = helper(m, n, i - 1, j, dp);
        int notTake = helper(m, n, i, j - 1, dp);

        return dp[i][j] = take + notTake;

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(m, n, m - 1, n - 1, dp);
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
      System.out.println(  uniquePaths(m, n));
    }
}
