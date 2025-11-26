package DynamicProgramming;

import java.util.Arrays;
public class coinChange {

    public static int countDenominationsCoin(int[] coins, int amount, int dp[][], int index) {

        if(index==0){
            if(amount % coins[0] == 0) return amount/coins[0];
            return  (int) 1e9;
        }

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int pick = (int) 1e9;
      
        if (coins[index] <= amount) {

            pick = 1+countDenominationsCoin(coins, amount - coins[index], dp, index);
        }
        int notpick = 0 + countDenominationsCoin(coins, amount, dp, index - 1);

        return dp[index][amount] = Math.min(notpick, pick);

    }

    public static int  coinchange(int[] coins, int amount) {
        int [][] dp=  new int[coins.length+1][amount+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        int ans = countDenominationsCoin(coins, amount, dp, coins.length-1);

        if(ans >=  (int) 1e9){
            return -1;
        }

        return ans;

    }

    public static void main(String[] args) {
        int numss[]= {1,2,5};
        int amount=11;

        System.out.println(coinchange(numss, amount));

    }
}
