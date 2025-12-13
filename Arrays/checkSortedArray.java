package Arrays;

public class checkSortedArray {
     public static boolean check(int[] nums) {

for (int i = 0; i < nums.length-1; i++) {

        if(nums[i] > nums[i+1]){
            return false;
        }
        
    }

    return true;



        
    }

    public static void main(String[] args) {
        int nums[]= {-1,1,3,4,5};

        System.out.println(check(nums));

    }
}
