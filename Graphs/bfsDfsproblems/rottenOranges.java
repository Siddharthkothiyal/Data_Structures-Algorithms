

import java.util.LinkedList;
import java.util.Queue;

class tuple {
    int row;
    int col;
    int tm;

    tuple(int _row, int _col, int _tm) {
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}

public class rottenOranges {
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<tuple> q = new LinkedList<>();
        int cntFreshOranges = 0;
        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new tuple(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    cntFreshOranges++;
            }
        }

        if (cntFreshOranges == 0)
            return 0;
        int countOfRotten = 0;
        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };
        int minTime = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            minTime = Math.max(minTime, t);

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new tuple(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    countOfRotten++;
                }
            }
        }

        if (countOfRotten != cntFreshOranges)
            return -1;

        return minTime;

    }

    public static void main(String[] args) {
        int[][] grid = { {2,1,1},{0,1,1},{1,0,1} };
        System.out.println(orangesRotting(grid));
    }
}
