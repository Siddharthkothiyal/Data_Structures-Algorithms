package Arrays;

public class sortcolors {
    public static void sortColors(int[] nums) {

        int mid = 0;
        int low = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };

        sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print( nums[i] + " ");
        }

    }
}
