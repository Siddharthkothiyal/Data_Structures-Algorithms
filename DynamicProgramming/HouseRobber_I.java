package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber_I {
     public static int maxRobs(int[] nums , int index , int[] dp) {

        if(index==0) return nums[index];
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

          int firstpick=  maxRobs(nums , index-1 , dp);

        int secondpick  = nums[index] + maxRobs(nums , index-2 , dp);
       

         return dp[index]= Math.max(firstpick,secondpick);
        
    }
    public int rob(int[] nums) {

       int dp[]= new int [nums.length +1];
       Arrays.fill(dp , -1);
      

       return maxRobs(nums ,nums.length-1 , dp);
    }

    
}
