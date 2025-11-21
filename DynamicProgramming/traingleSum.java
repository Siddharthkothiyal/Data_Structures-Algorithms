package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class traingleSum {
    public static int totalSum(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == triangle.size() - 1)
            return dp[i][j] = triangle.get(i).get(j);

        int take = triangle.get(i).get(j) + totalSum(triangle, i + 1, j, dp);
        int nottake = triangle.get(i).get(j) + totalSum(triangle, i + 1, j + 1, dp);

        return dp[i][j] = Math.min(take, nottake);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], -1);
        }
        return totalSum(triangle, 0, 0, dp);
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }
}
