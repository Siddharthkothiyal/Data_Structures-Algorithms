package DynamicProgramming.LCS;

import java.util.Arrays;

public class lcs1 {

    public static int findLCS(int i , int j ,String s1, String s2 , int [][] dp){

        if(i <0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i)== s2.charAt(j)){
            return 1+ findLCS(i-1, j-1, s1, s2, dp);
        }

        dp[i][j]= 0+Math.max(findLCS(i-1, j, s1, s2, dp), findLCS(i, j-1, s1, s2, dp));


        return dp[i][j];

    }
      public static int longestCommonSubsequence(String text1, String text2) {

        int [][] dp = new int[text1.length()+1][text2.length()+1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        return findLCS(text1.length()-1, text2.length()-1, text1, text2, dp);
        
    }

    public static void main(String[] args) {
        String text1 = "abc", text2 = "abc";
System.out.println(longestCommonSubsequence(text1, text2));

    }
}
