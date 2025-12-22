package Arrays;

public class nextpermutatioN {

    public static void reverseRemaining(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void nextPermutation(int[] nums) {

        int index = -1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverseRemaining(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > index; i--) {

            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;

            }

        }

        reverseRemaining(nums, index + 1, nums.length - 1);

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
nextPermutation(nums);

for (int i = 0; i < nums.length; i++) {
    System.out.print(nums[i]);
}
    }
}
