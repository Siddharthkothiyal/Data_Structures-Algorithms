package BinarySearch.BS_On_Answers;

public class shipPackages {

    public static int minCapacityWithinDays(int[] weights, int capacity) {
        int load = 0;
        int days = 0;

        for (int i = 0; i < weights.length; i++) {

            if (load + weights[i] <= capacity) {
                load += weights[i];
            } else {
                days++;
                load = weights[i];
            }
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < weights.length; i++) {
            start = Math.max(start, weights[i]);
            end += weights[i];
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (minCapacityWithinDays(weights, mid) >= days) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int nums[] = { 3,2,2,4,1,4 };
        int k = 3;
        System.out.println(shipWithinDays(nums, k));
    }

}
