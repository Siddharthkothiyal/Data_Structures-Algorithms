
package BinarySearch.BS_On_Answers;
public class smalllestDivisor {

    public static int finddivisor(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (Math.ceil((double) nums[i] / (double) divisor));
        }
        return sum;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, nums[i]);
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (finddivisor(nums, threshold, mid) <= threshold) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int nums[]= {44,22,33,11,1};
        int threshold=5;
      System.out.println(smallestDivisor(nums,threshold));
    }

}
