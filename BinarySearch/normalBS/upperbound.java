
public class upperbound {
    public static int upperBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,2,3 };
        int x = 2;

        System.out.println(upperBound(nums, x));

  
    }
}
