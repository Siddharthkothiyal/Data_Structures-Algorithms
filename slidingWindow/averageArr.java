package slidingWindow;

public class averageArr {
    public double findMaxAverage(int[] nums, int k) {

       int l = 0;
        int r = 0;

        double windowSum = 0;
        double maxSum = Double.NEGATIVE_INFINITY;

        while (r < nums.length) {

            windowSum += nums[r];   

          
            if (r - l + 1 == k) {

                maxSum = Math.max(maxSum, windowSum);

                windowSum -= nums[l];  
                l++;                   
            }

            r++;
        }

        return maxSum / k;

    }

    public static void main(String[] args) {
        
    }
}
