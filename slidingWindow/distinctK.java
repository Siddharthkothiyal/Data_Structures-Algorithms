package slidingWindow;

import java.util.HashMap;


public class distinctK {
    public static int CountDistinctSubs(int[] nums, int k) {
        int left = 0;
        int countSubs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            countSubs += (right - left + 1);
        }

        return countSubs;
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {

        return CountDistinctSubs(nums, k) - CountDistinctSubs(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));

    }

}
