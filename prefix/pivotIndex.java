package prefix;

public class pivotIndex {
    public static int pivotindex(int[] nums) {

        if (nums.length == 0)
            return -1;
        int totSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totSum = totSum - nums[i];
            if (leftSum == totSum)
                return i;
            leftSum += nums[i];
        }

        return -1;

    }

    public static void main(String[] args) {
        int nums[] = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotindex(nums));

    }

}
