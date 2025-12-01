package DynamicProgramming.dponStocks;

import java.util.Arrays;

public class dponStocks4 {
    public static int function(int index, int buy, int k, int[] prices, int dp[][][]) {
        if (index == prices.length)
            return 0;

        if (k == 0)
            return 0;
        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }
        int profit = 0;

        if (buy == 0) {
            profit += Math.max(-prices[index] + function(index+1, 1, k, prices, dp),
                    0 + function(index+1, 0, k, prices, dp));

        }
        if (buy == 1) {
            profit += Math.max(prices[index] + function(index+1, 0, k - 1, prices, dp),
                    0 + function(index+1, 1, k, prices, dp));

        }

        return dp[index][buy][k] = profit;

    }

    public static int maxProfit(int k , int[] prices) {

        int[][][] dp = new int[prices.length][2][k+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return function(0, 0, k, prices, dp);
    }

    public static void main(String[] args) {
        int []prices = {3,2,6,5,0,3};
        int k =2;

System.out.println(maxProfit(k , prices));
    }
    
}
