package BitManipulation.Arrays;

public class removeDuplicates {

    public static int removeduplicates(int[] nums) {

        int lastNumber = nums[0];

        int count = 0;

        for (int i = 1; i < nums.length; i++) {

            if (lastNumber != nums[i]) {
                count++;

                lastNumber = nums[i];
            }

        }

        return count+1;

    }

    public static void main(String[] args) {
       int nums[]= {1,1,2};
       System.out.println(removeduplicates(nums));


    }

}
