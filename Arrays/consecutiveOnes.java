package Arrays;

public class consecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {

          int count =0;
     int maxi=0;
     
     for(int i : nums){
        if(i==1){
            count++;
            maxi= Math.max(count , maxi);
        }else{
            count=0;
        }
     }

     return maxi;

        }

    }

