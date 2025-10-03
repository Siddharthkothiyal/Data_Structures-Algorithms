package BinarySearch.BS_On_Answers;
public class kokoEatingBananas {
 
    public static int totalHrs(int[] piles, int hourly) {
        int totHrs = 0;
        for (int i = 0; i < piles.length; i++) {
            totHrs += Math.ceil((double) piles[i] / (double) hourly);
        }
        return totHrs;

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int end = 0;
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(piles[i], end);
        }
        int start = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (totalHrs(piles, mid) <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }

}
