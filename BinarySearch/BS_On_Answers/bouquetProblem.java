package BinarySearch.BS_On_Answers;

public class bouquetProblem {

    public static boolean canBloom(int[] bloomDay, int m, int k, int day) {

        int count = 0;
        int bouquetsCount = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;

            } else {
                bouquetsCount += count / k;
                count = 0;
            }
        }
        bouquetsCount += count / k;
        return bouquetsCount >= m;

    }

    public static int minDays(int[] bloomDay, int m, int k) {
         if((long)m * (long)k > bloomDay.length) return -1;
        int end = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            end = Math.max(bloomDay[i], end);
        }
        int start = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (canBloom(bloomDay, m, k, mid)==true) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
}

      
  
