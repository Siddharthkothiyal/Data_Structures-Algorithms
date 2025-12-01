package DynamicProgramming.dponStocks;

import java.util.Arrays;

public class dponStocks3 {
    public static int function(int index, int buy, int cap, int[] prices, int dp[][][]) {
        if (index == prices.length)
            return 0;

        if (cap == 0)
            return 0;
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
        int profit = 0;

        if (buy == 0) {
            profit += Math.max(-prices[index] + function(index+1, 1, cap, prices, dp),
                    0 + function(index+1, 0, cap, prices, dp));

        }
        if (buy == 1) {
            profit += Math.max(prices[index] + function(index+1, 0, cap - 1, prices, dp),
                    0 + function(index+1, 1, cap, prices, dp));

        }

        return dp[index][buy][cap] = profit;

    }

    public static int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][2][3];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return function(0, 0, 2, prices, dp);
    }

    public static void main(String[] args) {
        int []prices = {3,3,5,0,0,3,1,4};

System.out.println(maxProfit(prices));
    }
}
