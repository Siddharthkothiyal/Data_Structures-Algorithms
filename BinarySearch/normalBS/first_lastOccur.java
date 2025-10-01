import java.util.Arrays;

public class first_lastOccur {

    public static int firstOccur(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        int first = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
                first = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }

    public static int secondOccur(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        int second = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
                second = mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return second;
    }
    public static int[] searchRange(int[] nums, int target) {

        return new int[]{firstOccur(nums, target), secondOccur(nums, target)};
    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10,10,10};
        int target = 10;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    }

