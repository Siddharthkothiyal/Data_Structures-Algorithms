import java.util.LinkedList;
import java.util.Queue;


class newtuple {
    int first;
    int second;
    int third;

    newtuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
public class matrix01 {


    public static int[][] updateMatrix(int[][] mat) {
        Queue<newtuple> q = new LinkedList<>();
        int[][] vis = new int[mat.length][mat[0].length];
        int dist[][] = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new newtuple(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }

        }

        int delRow[] = { -1, 0, 1, 0 };
        int delCol[] = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;

            q.remove();
            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < mat.length && ncol < mat[0].length
                        && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new newtuple(nrow, ncol, steps + 1));
                }

            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] result = updateMatrix(mat);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
