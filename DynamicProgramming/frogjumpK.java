package DynamicProgramming;

import java.util.Arrays;


public class frogjumpK {
    public static int function(int[] heights, int k, int index, int dp[]) {

        if (index == 0)
            return 0;

        if(dp[index] != -1) return dp[index];
        int minimumH=Integer.MAX_VALUE;
        for(int j=1 ; j<=k ; j++){
            if(index-j >= 0){
            int jump= function(heights, k, index-j, dp) +  Math.abs(heights[index] -heights[index-j]);
            minimumH= Math.min(jump, minimumH);
            }
        }

        return  dp[index]= minimumH;
    }

    public static int frogJump(int[] heights, int k) {
        int dp[]= new int[heights.length];
        Arrays.fill(dp, -1);
        return function(heights, k, heights.length-1, dp);
    }

    public static void main(String[] args) {
        int[] heights = {10, 5, 20, 0, 15};
        int k = 2;
        System.out.println(frogJump(heights, k));


    }

}
