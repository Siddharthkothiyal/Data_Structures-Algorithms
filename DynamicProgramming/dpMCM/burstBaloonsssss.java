package DynamicProgramming.dpMCM;

public class burstBaloonsssss {

    public static int maxSumPossible(int nums[], int i, int j) {

        if (i > j)
            return 0;
      

        int totSum = 0;
        for (int ind = i; ind <=j; ind++) {
            int ans = nums[i-1] * nums[ind] * nums[j+1] +
                       + maxSumPossible(nums, i, ind - 1)
                    + maxSumPossible(nums, ind + 1, j);
                    totSum = Math.max(ans , totSum);
        }
        return totSum;

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
        return maxSumPossible(nums2, 1, nums2.length-2  );

    }

    public static void main(String[] args) {

        int arr []= {3, 1,5,8};

        System.out.println(maxCoins(arr));


        
    }

}
