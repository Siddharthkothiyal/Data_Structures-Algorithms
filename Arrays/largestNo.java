package Arrays;


public class largestNo {
     public static int largestElement(int[] nums) {
    

        int maxi=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int nums[]= {3, 3, 0, 99, -40};
        System.out.println(largestElement(nums));
    }
}
