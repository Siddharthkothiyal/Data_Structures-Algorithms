package Arrays;

public class removeDuplicates {

    public static int removeduplicates(int[] nums) {

       

        int lastNumber = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[lastNumber] != nums[i]) {
                lastNumber++;  
                nums[lastNumber] = nums[i];
            }

        }

        return lastNumber+1;

    }

    public static void main(String[] args) {
       int nums[]= {1,1,2};
       System.out.println(removeduplicates(nums));


    }

}
