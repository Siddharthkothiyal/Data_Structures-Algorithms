package Greedy;

import java.util.Arrays;

public class sjf {

    public static int shortestJB(int [] nums){

        Arrays.sort(nums);

        int t=0;
        int wt=0;

        for (int i = 0; i < nums.length; i++) {
            wt += t;
            t+=nums[i];
        }

        return wt/nums.length;

    }

    public static void main(String[] args) {
        
        int [] nums ={4, 3, 7,1,2};

        System.out.println(shortestJB(nums));
    }
    
}
