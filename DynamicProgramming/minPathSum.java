package DynamicProgramming;

import java.util.Arrays;

public class minPathSum {
      public static int helper(int matrix[][], int i, int j, int[][] dp) {

        if (i == 0 && j == 0) {
            return matrix[i][j];
        }

        if (i < 0 || j < 0)
            return (int)1e9;;


        if (dp[i][j] != -1)
            return dp[i][j];

        int take =  matrix[i][j]+ helper(matrix, i - 1, j, dp);
        int notTake =  matrix[i][j]+helper(matrix, i, j - 1, dp);

        return dp[i][j] =Math.min(take, notTake);

    }
       public static int minpathSum(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return helper(grid, n-1, m-1, dp);


    }

    public static void main(String[] args) {
       int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
       System.out.println(minpathSum(grid));
    }
}
