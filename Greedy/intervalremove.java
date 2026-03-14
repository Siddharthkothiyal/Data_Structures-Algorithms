package Greedy;

import java.util.Arrays;

public class intervalremove {
    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int[] newInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {

            int interval[] = intervals[i];

            if (newInterval[1] > interval[0]) {
                count++;

            } else {
                newInterval = interval;
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
