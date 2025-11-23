package DynamicProgramming;

import java.util.Arrays;

public class fallingPathSum {

  public static int fallingPathSumCalc(int[][] matrix, int i, int j, int[][] dp) {
    int m = matrix[0].length;
    int maxvalue = (int) 1e9;
    if (j < 0 || j >= m)
      return maxvalue;

    if (i == 0)
      return matrix[0][j];

    if (dp[i][j] != -1)
      return dp[i][j];

    int leftDiagonal = fallingPathSumCalc(matrix, i - 1, j - 1, dp);
    int up = fallingPathSumCalc(matrix, i - 1, j, dp);
    int rightDiagonal = fallingPathSumCalc(matrix, i - 1, j + 1, dp);

    if (leftDiagonal != maxvalue)
      leftDiagonal += matrix[i][j];
    if (up != maxvalue)
      up += matrix[i][j];
    if (rightDiagonal != maxvalue)
      rightDiagonal += matrix[i][j];

    return dp[i][j] = Math.min(leftDiagonal, Math.min(up, rightDiagonal));
  }

  public static int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n][m];
    for (int[] d : dp) {
      Arrays.fill(d, -1);
    }
    int mini = (int) 1e9;
    for (int i = 0; i < matrix.length; i++) {

      mini = Math.min(mini, fallingPathSumCalc(matrix, n - 1, i, dp));
    }

    return mini;
  }

  public static void main(String[] args) {

    int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
    System.out.println(minFallingPathSum(matrix));

  }
}
