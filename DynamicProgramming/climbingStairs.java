package DynamicProgramming;

import java.util.Arrays;

public class climbingStairs {
    public static int func(int n, int dp[], int index) {
        if (index == 0)
            return 1;
        if (index == 1)
            return 1;

        if (dp[index] != -1)
            return dp[index];

        int left = func(n, dp, index - 1);
        int right = func(n, dp, index - 2);

        return dp[index] = left + right;

    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return func(n, dp, n);
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(climbStairs(n));
    }

}
