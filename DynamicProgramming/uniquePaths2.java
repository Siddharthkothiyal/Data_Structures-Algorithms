package DynamicProgramming;

import java.util.Arrays;

public class uniquePaths2 {
    public static int helper(int matrix[][], int i, int j, int[][] dp) {

        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0)
            return 0;

        if (matrix[i][j] == 1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = helper(matrix, i - 1, j, dp);
        int notTake = helper(matrix, i, j - 1, dp);

        return dp[i][j] = take + notTake;

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return helper(obstacleGrid, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
