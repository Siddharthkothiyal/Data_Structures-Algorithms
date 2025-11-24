package DynamicProgramming;

import java.util.Arrays;

public class partitionSum {
    public static int givesPartitionSubset(int[] nums, int target, int index, int[][] dp) {
        if (index == 0) {
            if (nums[0] == target && target == 0) {
                return 2;
            }
            if (nums[0] == target || target == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[index][target] != -1)
            return dp[index][target];

        int notPick = givesPartitionSubset(nums, target, index - 1, dp);

        int pick = 0;
        if (nums[index] <= target) {
        pick = givesPartitionSubset(nums, target - nums[index],index- 1, dp);
        }
       return  dp[index][target] = pick | notPick;
    }

    public static boolean canPartition(int[] nums) {
        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            target += nums[i];
        }

        if (target % 2 == 1)
            return false;

        target = target / 2;

        int[][] dp = new int[nums.length + 1][target + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

return (givesPartitionSubset(nums, target, nums.length - 1, dp) == 1);

    }

    public static void main(String[] args) {
        int nums[]= {1,2,3,4};
        if(canPartition(nums)){
            System.out.println("true");
        }else{
            System.out.println(false);
        }
        
    }
}
