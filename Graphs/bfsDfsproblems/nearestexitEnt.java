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

public class nearestexitEnt {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        Queue<tuple> q = new LinkedList<>();
        int vis[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == '+') {
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };

        q.add(new tuple(entrance[0], entrance[1], 0));

        int dist = 0;

        while (!q.isEmpty()) {

            int first = q.peek().row;
            int second = q.peek().col;
            int third = q.peek().tm;

            dist = Math.max(dist, third);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = first + delRow[i];
                int ncol = second + delCol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m
                        && vis[nrow][ncol] != 2
                        && vis[nrow][ncol] == 0 && maze[nrow][ncol] == '.') {

                    if ((nrow == 0 || ncol == 0 || nrow == n - 1 || ncol == m - 1) &&
                            !(nrow == entrance[0] && ncol == entrance[1])) {
                        return dist + 1;
                    } else {
                        vis[nrow][ncol] = 1;
                        q.add(new tuple(nrow, ncol, third + 1));
                    }

                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
char [][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
int [] entrance = {1,2};

System.out.println(nearestExit(maze, entrance));


    }
}
