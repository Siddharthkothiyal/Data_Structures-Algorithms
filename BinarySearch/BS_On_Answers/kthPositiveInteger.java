package BinarySearch.BS_On_Answers;

public class kthPositiveInteger {
    public static int findkthInteger(int[] nums, int k) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            int missingNumber = nums[mid] - (mid + 1);

            if (missingNumber <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start + k;

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int k = 2;

        System.out.println(findkthInteger(nums, k));
    }
}
