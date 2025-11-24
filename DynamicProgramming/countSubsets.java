package DynamicProgramming;

import java.util.Arrays;
public class countSubsets {
    public static int funcTion(int[] arr, int target, int index, int[][] dp) {

        if (target == 0)
            return 1;

        if (index == 0) {
            return (arr[0] == target) ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int pick = 0;
        if (arr[index] <= target) {
            pick = funcTion(arr, target - arr[index], index - 1, dp);
        }

        int notPick = funcTion(arr, target, index - 1, dp);

        return dp[index][target] = pick + notPick;
    }

    public static int perfectSum(int[] arr, int K) {

        int[][] dp = new int[arr.length][K + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return funcTion(arr, K, arr.length - 1, dp);

    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 16, 8, 10 };
        int K = 10;

        System.out.println(perfectSum(arr, K));
    }
}
