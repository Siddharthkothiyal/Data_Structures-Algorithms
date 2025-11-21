package DynamicProgramming;

import java.util.Arrays;

public class ninjasTraining {

    public static int getActivity(int[][] matrix, int day, int last, int[][] dp) {

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, matrix[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            int activity = 0;
            if (i != last) {
                activity = getActivity(matrix, day - 1, i, dp) + matrix[day][i];
            }
            maxi = Math.max(maxi, activity);
        }
        return dp[day][last] = maxi;

    }

    public static int ninjaTraining(int[][] matrix) {
        int[][] dp = new int[matrix.length][4];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return getActivity(matrix, matrix.length - 1, 3, dp);
    }

    public static void main(String[] args) {

        int[][] matrix = { { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 } };

        System.out.println(ninjaTraining(matrix));

    }
}
