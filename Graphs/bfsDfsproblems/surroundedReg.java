public class surroundedReg {

    public static void dfs(int row, int col, char[][] board, int vis[][]) {
        int n = board.length;
        int m = board[0].length;

        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0) {
                vis[nrow][ncol] = 1;
                dfs(nrow, ncol, board, vis);
            }

        }

    }

    public static void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];

        // first row

        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == 'O' && vis[0][i] == 0) {
                vis[0][i] = 1;
                dfs(0, i, board, vis);
            }

        }

        // last row

        for (int i = 0; i < board.length; i++) {
            if (board[n - 1][i] == 'O' && vis[n - 1][i] == 0) {
                vis[n - 1][i] = 1;
                dfs(n - 1, i, board, vis);
            }

        }

        // first col

        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                vis[i][0] = 1;
                dfs(i, 0, board, vis);
            }

        }

        // last col

        for (int i = 0; i < board.length; i++) {
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                vis[i][m - 1] = 1;
                dfs(i, m - 1, board, vis);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] matrix = { { 'X'} };

        solve(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
    }
    }
}
