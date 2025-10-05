package Graphs.bfsDfsproblems;

import java.util.Arrays;

public class floodFill {

    public static void fillneighbours(int[][] image, int[][] flood, int sr, int sc, int newcolor, int[] delrwow,
            int[] delcol, int initialcolor) {

        flood[sr][sc] = newcolor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = sr + delrwow[i];
            int ncol = sc + delcol[i];

            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && image[nrow][ncol] == initialcolor
                    && flood[nrow][ncol] != newcolor) {
                fillneighbours(image, flood, nrow, ncol, newcolor, delrwow, delcol, initialcolor);

            }
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialcolor = image[sr][sc];
        if (initialcolor == color) return image; 
        int[][] flood = image; 

        int delrow[] = { -1, 0, 1, 0 };
        int delcol[] = { 0, -1, 0, 1 };

        fillneighbours(image, flood, sr, sc, color, delrow, delcol, initialcolor);
        return flood;
    }

    public static void main(String[] args) {

      int image[][]=  {{1,1,1},{1,1,0},{1,0,1}} ;
        int sr = 1;
        int  sc = 1;
        int  color = 2;

      int[][] result = floodFill(image, sr, sc, color);

        // Properly print 2D array
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

    }

}
