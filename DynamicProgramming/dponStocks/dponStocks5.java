package DynamicProgramming.dponStocks;

import java.util.Arrays;

public class dponStocks5 {
    public static int function(int index, int buy, int fee , int[] prices, int dp[][]) {
        if (index >= prices.length)
            return 0;

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int profit = 0;

        if (buy == 0) {
            profit += Math.max(-prices[index] + function(index + 1, 1,fee, prices, dp),
                    0 + function(index + 1, 0,fee, prices, dp));

        }
        if (buy == 1) {
            profit += Math.max(prices[index] + function(index + 2, 0,fee, prices, dp),
                    0 + function(index + 1, 1,fee, prices, dp));

        }

        return dp[index][buy] = profit;

    }

    public static int maxProfit(int[] prices , int fee) {

        int[][] dp = new int[prices.length][2];

     for (int[] is : dp) {
                    Arrays.fill(is, -1);
                }
            
     

        return function(0, 0, fee, prices, dp);
    }

    public static void main(String[] args) {
        int[] prices = { 1,3,2,8,4,9 };

        System.out.println(maxProfit(prices, 0));
    }
}
