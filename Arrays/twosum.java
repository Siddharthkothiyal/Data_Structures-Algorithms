package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class twosum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if (map.containsKey(number)) {

                return new int[] { map.get(number), i };
            } else {
                map.put(nums[i], i);
            }

        }
        return new int[] {-1 , -1};
    }

    public static void main(String[] args) {
        int nums[] = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
