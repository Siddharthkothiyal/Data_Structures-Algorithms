package DynamicProgramming;

import java.util.Arrays;

public class coinchange2 {
    public static int countDenominationsCoin(int[] coins, int amount, int dp[][], int index) {

        if (index == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int pick = 0;

        if (coins[index] <= amount) {

            pick = countDenominationsCoin(coins, amount - coins[index], dp, index);
        }
        int notpick = countDenominationsCoin(coins, amount, dp, index - 1);

        return dp[index][amount] = pick + notpick;

    }

    public static int coin(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        int ans = countDenominationsCoin(coins, amount, dp, coins.length - 1);

        if (ans >= (int) 1e9) {
            return 0;
        }

        return ans;

    }

    public static void main(String[] args) {
        int numss[] = { 1, 2, 5 };
        int amount = 5;

        System.out.println(coin(amount, numss));

    }
}
