package BinarySearch.BS_On_Answers;

import java.util.Arrays;

public class aggresiveCows {
    // can this cow be placed here
    public static boolean canWePlace(int[] stalls, int k, int dist) {
        int placedCow = stalls[0];
        int count = 1;

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - placedCow >= dist) {
                count++;
                placedCow = stalls[i];
            }
                 if(count >= k)  return true;
        }
        return false;

    }

    public static int aggressiveCows(int[] stalls, int k) {
         Arrays.sort(stalls);
        int start = 1;
        int end = stalls[stalls.length-1] - stalls[0];

        while (start <= end) {
            int mid = (start + end) / 2;

            if (canWePlace(stalls, k, mid)) {
            
                start = mid + 1;
            }else{
            end = mid - 1;
        }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] stalls = { 10, 1, 2, 7, 5};
        int k = 3;
        System.out.println(aggressiveCows(stalls, k));
    }
}
