package DynamicProgramming;

import java.util.Arrays;

public class subsetSumT {

    public static boolean funcTion(int[] arr, int target, int index, int[][] dp) {

        if (target == 0)
            return true;

        if (index == 0) {
            return arr[0] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }
        boolean pick = false;

        if (arr[index] <= target) {
            pick = funcTion(arr, target - arr[index], index - 1, dp);
        }

        boolean notPick = funcTion(arr, target, index - 1, dp);

        dp[index][target] = notPick || pick ? 1 : 0;
        return notPick || pick;
    }

    public static boolean isSubsetSum(int[] arr, int target) {

        int[][] dp = new int[arr.length][target + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }
        return funcTion(arr, target, arr.length - 1, dp);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5 };
        int target = 6;
        if (isSubsetSum(arr, target))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
