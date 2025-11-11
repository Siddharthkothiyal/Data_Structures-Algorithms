package slidingWindow;


public class niceSubARR {
    public static int countSubArr(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int subCount = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }
            subCount += right - left + 1;
        }
        return subCount;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return countSubArr(nums, k) - countSubArr(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 2,2,2,1,2,2,1,2,2,2 };
        int k = 2;

        int ans = numberOfSubarrays(nums, k);
        System.out.println(ans);
    }

}
