import java.util.Arrays;

public class floor_ceil {

    
    public static int floor(int nums[], int x) {
      int start = 0;
        int end = nums.length;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (nums[mid] >= x) {
               end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return nums[end];

    }
public static int ceil(int nums[], int x) {
     int start = 0;
        int end = nums.length;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (nums[mid] >= x) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return nums[start];
}
     public static int[] getFloorAndCeil(int[] nums, int x) {
       return new int[]{floor(nums, x), ceil(nums, x)};
       
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 4, 7, 8, 10 };
        int x = 5;
        System.out.println(Arrays.toString(getFloorAndCeil(nums, x)));
    }
}
