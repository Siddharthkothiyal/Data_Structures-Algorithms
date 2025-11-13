package slidingWindow;

public class maxPointsCards {
    public static int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int maxSum = 0;
         int rightSum = 0;
        for (int i = 0; i < k; i++)  leftSum += cardPoints[i];


            maxSum = leftSum;
            int rightIndex = cardPoints.length - 1;
            for (int j = k - 1; j >= 0; j--) {
                leftSum -= cardPoints[j];
                rightSum += cardPoints[rightIndex];
             
                    rightIndex--;
                        maxSum = Math.max(maxSum, leftSum + rightSum);
            }
          
            return maxSum;
        }
       
    
    public static void main(String[] args) {

int []cardPoints = {1,2,3,4,5,6,1};
int  k = 3;
System.out.println(maxScore(cardPoints, k));


        
    }
}
