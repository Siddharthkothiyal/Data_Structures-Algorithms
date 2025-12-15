package Arrays;

import java.util.Arrays;

public class majorityElem {
      public static int majorityElement(int[] nums) {

         Arrays.sort(nums);

        return nums[nums.length/2];
        
    }

    public static void main(String[] args) {

        int nums[]= {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));
    }
}
