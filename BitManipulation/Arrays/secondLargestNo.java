package BitManipulation.Arrays;

public class secondLargestNo {
      public static int secondLargestElement(int[] nums) {

        int largestElement=0;
        int secondLargestElem=Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > largestElement){
                secondLargestElem= largestElement;
                largestElement= nums[i];

            }else if(nums[i] > secondLargestElem && nums[i] != largestElement ){
                secondLargestElem= nums[i];
            }
            
        }

        return secondLargestElem;
    
    }

    public static void main(String[] args) {
           int nums[]= {8, 8, 7, 6, 5};

           System.out.println(secondLargestElement(nums));


    }
}
