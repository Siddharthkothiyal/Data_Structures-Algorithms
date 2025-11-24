package DynamicProgramming;

import java.util.Arrays;

public class countPartitions {

    public static int funcTion(int[] arr, int target, int index, int[][] dp) {

        // Base case
        if (index == 0) {

            // Case 1: arr[0] == 0 and target == 0 → 2 ways (pick or not pick)
            if (target == 0 && arr[0] == 0) return 2;

            // Case 2: target == 0 → only 1 way (not pick)
            if (target == 0) return 1;

            // Case 3: target == arr[0] → 1 way (pick)
            if (target == arr[0]) return 1;

            return 0;
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

    public static int countpartitions(int n, int diff, int[] arr) {
        int totalSum = 0;
        for (int x : arr) totalSum += x;

        // Base conditions
        if (totalSum - diff < 0) return 0;
        if ((totalSum - diff) % 2 == 1) return 0;

        int s2 = (totalSum - diff) / 2;

        int[][] dp = new int[n][s2 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return funcTion(arr, s2, n - 1, dp);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3 };
        int d = 1;
        int n = arr.length;

        System.out.println(countpartitions(n, d, arr)); 
        // Expected Output: 1
    }
}
