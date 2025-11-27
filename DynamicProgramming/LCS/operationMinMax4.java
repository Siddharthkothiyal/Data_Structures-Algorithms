package DynamicProgramming.LCS;

import java.util.Arrays;

public class operationMinMax4 {

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

     public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

           int[][] dp = new int[n + 1][m + 1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        return (n+m )- 2*(findLCS(n-1, m-1, word1, word2, dp));
        
    }

public static void main(String[] args) {
    String word1 = "leetcode", word2 = "etco";
    System.out.println(minDistance(word1, word2));
}
}
