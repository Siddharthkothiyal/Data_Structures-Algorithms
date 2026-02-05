package DynamicProgramming.dpMCM;

import java.util.Arrays;

public class burstBaloonsssss {

    public static int maxSumPossible(int nums[], int i, int j , int dp[][]) {

        if(dp[i][j] != -1) return dp[i][j];

        if (i > j)
            return 0;
      

        int totSum = 0;
        for (int ind = i; ind <=j; ind++) {
            int ans = nums[i-1] * nums[ind] * nums[j+1] +
                       + maxSumPossible(nums, i, ind - 1, dp)
                    + maxSumPossible(nums, ind + 1, j, dp);
                    totSum = Math.max(ans , totSum);
        }
        return dp[i][j] = totSum;

    }

    public static int[] addFirstLast(int[] arr) {
        int[] res = new int[arr.length + 2];
        res[0] = 1;
        res[res.length - 1] = 1;
        System.arraycopy(arr, 0, res, 1, arr.length);
        return res;
    }

    public static int maxCoins(int[] nums) {
        int[] nums2= addFirstLast(nums);
        int n = nums2.length;

        int dp[][]= new int[n+1][n+1];

        for (int [] arr : dp) {
            Arrays.fill(arr , -1);
        }
        return maxSumPossible(nums2, 1, nums2.length-2 , dp );

    }

    public static void main(String[] args) {

        int arr []= {3, 1,5,8};

        System.out.println(maxCoins(arr));


        
    }

}
