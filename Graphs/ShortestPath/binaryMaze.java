package Graphs.ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

public class binaryMaze {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // if there is no ShortestPath
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int dist[][] = new int[n][n];
        for (int[] is : dist) {
            Arrays.fill(is, (int) 1e9);
        }

        dist[0][0]=1;

        int[][] directions = {
                { -1, -1 }, { -1, 0 }, 
                { -1, 1 },  { 0, -1 }, 
                { 0, 1 },   { 1, -1 }, 
                { 1, 0 },   { 1,  1 }
        };

        Queue<Triplet> q = new LinkedList<>();

        q.add(new Triplet(1, 0, 0));

        while (!q.isEmpty()) {
            int dis = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;

            q.remove();
            if (row == n - 1 && col == n - 1)
                return dis;

            for (int dir[] : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n
                        && grid[nrow][ncol] == 0 && 1 + dis < dist[nrow][ncol]) {

                    dist[nrow][ncol] = 1 + dis;
                    q.add(new Triplet(1 + dis, nrow, ncol));

                }

            }
        }
        return -1;

    }

    public static void main(String[] args) {
       int grid[][] = {{0,1},{1,0}} ;

       System.out.println(shortestPathBinaryMatrix(grid));
    }
}
