package Arrays;

public class missingNumber {
     public  static int missingnumber(int[] nums) {

        int n = nums.length;
        int total = (n*(n+1))/2;
        int sum=0;

        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
        }

        return total- sum;

        
    }

    public static void main(String[] args) {
        int [] nums= {3,0,1};

        System.out.println(missingnumber(nums));

    }
}
