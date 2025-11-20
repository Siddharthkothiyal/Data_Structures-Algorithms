package DynamicProgramming;

import java.util.Arrays;

public class frogJumpN {

    public static int function(int[] heights, int index, int dp[]) {
        if (index == 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];

        int jumpOne = function(heights, index - 1, dp) + Math.abs(heights[index] - heights[index - 1]);

        int jumpTwo = Integer.MAX_VALUE;
        if (index > 1) {
            jumpTwo = function(heights, index - 2, dp) + Math.abs(heights[index] - heights[index - 2]);

        }
        return dp[index] = Math.min(jumpOne, jumpTwo);

    }

    public static int frogJump(int[] heights) {
        int[] dp = new int[heights.length ];
        Arrays.fill(dp, -1);

        return function(heights, heights.length - 1, dp);

    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 3, 5, 4 };
        System.out.println(frogJump(heights));
    }
}
