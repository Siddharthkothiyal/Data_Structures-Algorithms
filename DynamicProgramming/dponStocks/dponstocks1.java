package DynamicProgramming.dponStocks;

public class dponstocks1 {
    public static int maxProfit(int[] prices) {

        int profit = 0;
        int mini = prices[0];

        for (int i = 1; i <prices.length; i++) {
            profit = Math.max(prices[i] - mini, profit);
            mini = Math.min(mini, prices[i]);
        }
        return profit;

    }

    public static void main(String[] args) {
        int[] prices = { 7,6,4,3,1 };
        System.out.println(maxProfit(prices));
    }
}
