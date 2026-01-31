package DynamicProgramming.dpMCM;

import java.util.Arrays;

public class minCostStickCut {

    public static int mincostfindFun(int n, int[] cuts, int i, int j, int[][] dp) {

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i > j)
            return 0;

        int minCost = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {

            int cut = cuts[j + 1] - cuts[i - 1] + mincostfindFun(n, cuts, i, ind - 1, dp)
                    + mincostfindFun(n, cuts, ind + 1, j, dp);

            minCost = Math.min(minCost, cut);

        }

        return dp[i][j] = minCost;

    }

    public static int minCost(int n, int[] cuts) {

 int c = cuts.length;

        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        newCuts[c + 1] = n;

        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts[i];
        }

        Arrays.sort(newCuts);

        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

       return mincostfindFun(n, newCuts, 1, c, dp);

    }

    public static void main(String[] args) {
        int [] cuts= {3, 5, 1, 4};
        int n = 7;

        System.out.println(minCost(n, cuts));

    }

}
