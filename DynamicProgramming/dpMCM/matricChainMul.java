package DynamicProgramming.dpMCM;

public class matricChainMul {

    public static int minMultplyCost(int i, int j, int[] nums) {

        if (i==j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for (int index = i; index < j; index++) {
            int cost = (nums[i-1] * nums[index] * nums[j]) + 
             + minMultplyCost(i, index, nums)+
            minMultplyCost(index+1, j, nums);

           
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public static int matrixMultiplication(int[] nums) {
        return minMultplyCost(1, nums.length - 1, nums);

    }

    public static void main(String[] args) {
        int nums[] = { 10, 15, 20, 25 };
        System.out.println(matrixMultiplication(nums));

    }
}
