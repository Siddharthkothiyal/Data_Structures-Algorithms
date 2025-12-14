package Arrays;

public class linearSearch {

    public static int linearsearch(int nums[], int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
              return i;
            }
            
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 4, 5, 3 };
        int target = 3;

        System.out.println(linearsearch(nums, target));

    }

}
