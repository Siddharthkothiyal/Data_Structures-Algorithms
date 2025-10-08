public class noofEnclaves {

    public void dfs(int[][] grid, int row,int col,  int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int nrow = row + delRow[k];
            int ncol = col + delCol[k];

            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0
                    && grid[nrow][ncol] == 1) {
                vis[nrow][ncol] = 1;
                dfs(grid, nrow, ncol, vis);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = 0;
            }
        }

         for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                vis[0][j] = 1;
                dfs(grid, 0, j, vis);
            }
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                vis[n - 1][j] = 1;
                dfs(grid, n - 1, j, vis);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                vis[i][0] = 1;
                dfs(grid, i, 0, vis);
            }
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                vis[i][m - 1] = 1;
                dfs(grid, i, m - 1, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
        noofEnclaves obj = new noofEnclaves();
        System.out.println(obj.numEnclaves(grid));
    }

}
