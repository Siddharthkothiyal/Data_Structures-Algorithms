package DynamicProgramming.LIS;

import java.util.Arrays;


public class lis1 {
     public static int lis(int[]nums , int index , int last , int [][] dp) {

        if(index== nums.length) return 0;

        if(dp[index][last+1] != -1) return dp[index][last+1] ;


        int length = 0+ lis(nums, index+1, last, dp);  //not take
        if(last == -1 || nums[index] > nums[last]){
            length  = Math.max(1+ lis(nums, index+1, index, dp), length); //max of take or nottake
            
        }

        return dp[index][last+1] = length;
        
    }

     public static int lengthOfLIS(int[] nums) {

        int [][] dp = new int[nums.length][nums.length+1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return lis(nums, 0, -1, dp);

        
    }
public static void main(String[] args) {
    int []nums = {10,9,2,5,3,7,101,18};
    System.out.println(lengthOfLIS(nums));

}
    
}
