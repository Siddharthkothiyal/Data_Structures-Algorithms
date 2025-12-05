package DynamicProgramming;

import java.util.Arrays;

public class zeroOneKnapsack {
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

            take = val[index] + function(wt, val, n, W - wt[index], index-1, dp);
        }

      return  dp[index][W] = Math.max(take, notTake);

    }

     public static int knapsack(int W, int val[], int wt[]) {
int n = wt.length;
        int dp[][]= new int[n+1][W+1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);   
        }
       return  function(wt, val, n, W, n-1, dp);

    }

    public static void main(String[] args) {
        int [] val = {1, 2, 3};
         int [] wt = {4, 5, 1};
          int W = 4;


          System.out.println(knapsack(W, val, wt));

    }
}
