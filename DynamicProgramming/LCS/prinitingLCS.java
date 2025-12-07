package DynamicProgramming.LCS;

import java.util.Arrays;

public class prinitingLCS {

    public static int findLCS(int i, int j, String s1, String s2, int[][] dp) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + findLCS(i - 1, j - 1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(
                findLCS(i - 1, j, s1, s2, dp),
                findLCS(i, j - 1, s1, s2, dp)
        );
    }

    public static String printLCS(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        // fill dp with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // compute dp using memo
        findLCS(n - 1, m - 1, text1, text2, dp);

        // print LCS by backtracking
        int i = n - 1;
        int j = m - 1;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {

            // characters match → part of LCS
            if (text1.charAt(i) == text2.charAt(j)) {
                sb.append(text1.charAt(i));
                i--;
                j--;
            }
            else {
                // if i-1 < 0, we cannot access dp[i-1]
                int up = (i > 0) ? dp[i - 1][j] : -1;
                int left = (j > 0) ? dp[i][j - 1] : -1;

                if (up >= left) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return sb.reverse().toString();
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] is : dp) Arrays.fill(is, -1);

        return findLCS(text1.length() - 1, text2.length() - 1, text1, text2, dp);
    }

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";

        System.out.println("LCS: " + printLCS(text1, text2));
        System.out.println("Length: " + longestCommonSubsequence(text1, text2));
    }
}
