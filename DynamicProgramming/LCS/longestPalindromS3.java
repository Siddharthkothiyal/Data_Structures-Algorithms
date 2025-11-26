package DynamicProgramming.LCS;

import java.util.Arrays;

public class longestPalindromS3 {

    public static int findLCS(int i, int j, String s1, String s2, int[][] dp) {

        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + findLCS(i - 1, j - 1, s1, s2, dp);
        }
        dp[i][j] = 0 + Math.max(findLCS(i - 1, j, s1, s2, dp), findLCS(i, j - 1, s1, s2, dp));
        return dp[i][j];
    }

    public static int longestPalindromeSubseq(String s) {

        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        return findLCS(n - 1, m - 1, s, s2, dp);

    }

    public static void main(String[] args) {

        String s = "bbbab";

        System.out.println(longestPalindromeSubseq(s));


    }
}
