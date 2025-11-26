package DynamicProgramming.LCS;

import java.util.Arrays;

public class lcs2 {

    public static int calculateLength(String str1, String str2, int i, int j, int[][] dp) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int pick = 0;
        int maxi = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            pick = 1 + calculateLength(str1, str2, i - 1, j - 1, dp);
            maxi = Math.max(maxi, pick);
        } else {
            maxi = 0;
        }

        return dp[i][j] = maxi;
    }

    public static int longestCommonSubstr(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int n = str1.length();
        int m = str2.length();
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        int ans = 0;

        // Check for all pairs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               ans= Math.max(ans, calculateLength(str1, str2, i, j, dp));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "abcdxyz", str2 = "xyzabcd";
        System.out.println(longestCommonSubstr(str1, str2));
    }
}
