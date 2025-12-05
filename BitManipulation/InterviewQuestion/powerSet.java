package BitManipulation.InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class powerSet {
    public static List<List<Integer>> subsets(int[] nums) {

        int subsets = 1 << nums.length; // 2^n

        List<List<Integer>>totalSubs = new ArrayList<>();
        for (int num = 0; num < subsets ; num++) {
 ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {

                if ((num & (1 << i))!= 0) {
                    list.add(nums[i]);
                }
            }

            totalSubs.add(list);

        }
        return totalSubs;

    }

    public static void main(String[] args) {
        int [] nums= {1,2,3};
System.out.println(subsets(nums));

    }
}
