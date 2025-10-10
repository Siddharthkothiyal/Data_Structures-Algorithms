package Graphs.ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;


class Triplet {
    int first;
    int second;
    int third;

    Triplet(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

public class pathwithmineffort {
    public static int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int dist[][] = new int[n][m];
        for (int dis[] : dist) {
            Arrays.fill(dis, (int) 1e9);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        dist[0][0] = 0;

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        pq.add(new Triplet(0, 0, 0));

        while (pq.size() != 0) {
            int difference = pq.peek().first;
            int row = pq.peek().second;
            int col = pq.peek().third;

            pq.remove();

            if (row == n - 1 && col == m - 1)
                return difference;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                    int effort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), difference);

                    if(effort< dist[nrow][ncol]){
                    dist[nrow][ncol] = effort;
                    pq.add(new Triplet(effort, nrow, ncol));
                }
            }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int heights[][]= { {1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
}
