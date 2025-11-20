package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber_II {
   public static int function(int [] nums , int index ,int start , int end,  int dp[]){
    
        if(index < start) return 0;
        if (index == start) return nums[index];

        if(dp[index] != -1 ) return dp[index];

        int pick = nums[index ]+function(nums ,index-2 ,start , end , dp);
        int notpick =function(nums ,index-1 ,start , end , dp);

         return dp[index] = Math.max(pick , notpick);
    }

    public int rob(int[] nums) {

        int dp[] = new int[nums.length + 1];
        int dp1[] = new int[nums.length + 1];

          Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);

        if(nums.length == 0) return 0;
        
        if(nums.length == 1) return nums[0];

        int first = function(nums, nums.length - 2, 0, nums.length - 2, dp);
        int second = function(nums, nums.length - 1, 1, nums.length - 1, dp1);

        return Math.max(first, second);

    } 
}
