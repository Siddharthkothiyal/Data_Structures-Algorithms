package DynamicProgramming;

import java.util.Arrays;

public class unboundedKnapSack {

    public static int function(int[] wt, int[] val, int n, int W, int index, int[][] dp) {

        if (index == 0) {
            return (W / wt[0]) * val[0];
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int notTake = 0 + function(wt, val, n, W, index - 1, dp);

        int take = Integer.MIN_VALUE;

        if (wt[index] <= W) {

            take = val[index] + function(wt, val, n, W - wt[index], index, dp);
        }

      return  dp[index][W] = Math.max(take, notTake);

    }

    public static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {

        int dp[][]= new int[n+1][W+1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);   
        }
       return  function(wt, val, n, W, n-1, dp);

    }

    public static void main(String[] args) {
        int [] val = {10, 40, 50, 70};
         int [] wt = {1, 3, 4, 5};
          int W = 8;


          System.out.println(unboundedKnapsack(wt, val, wt.length, W));

    }

}
