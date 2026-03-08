public class findPivot {
    public static int pivotIndex(int[] nums) {
        int totSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {

            leftSum += nums[i];
            totSum -= nums[i];

            if (leftSum == totSum) {
                return i;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(nums));

    }

}
