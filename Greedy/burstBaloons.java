package Greedy;

import java.util.Arrays;

public class burstBaloons {
    
     public static int findMinArrowShots(int[][] points) {
          Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int[] newInterval = points[0];
        for (int i = 1; i < points.length; i++) {

            int interval[] = points[i];
            if (newInterval[1] <interval[0]) {
                count++;
                 newInterval = interval;
            }
    }
    
        return count;
}

    public static void main(String[] args) {
      int [][]  points = {{10,16},{2,8},{1,6},{7,12}};

      System.out.println(findMinArrowShots(points));
        
    }
}
