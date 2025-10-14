package Graphs.ShortestPath;

public class floydWarshell {

    public static void floydWarshall(int[][] dist) {

      
        int n = dist.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == -1) {
                    dist[i][j] = (int) 1e9;
                }

                if (i == j)
                    dist[i][j] = 0;

            }
        }

        // update the matrix with minimum values;
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if(dist[i][via] != (int) 1e9 ||dist[via][j] != (int) 1e9){
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                    }
                }
            }
        }

         for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if(dist[i][j]== (int) 1e9){
                    dist[i][j] = -1;
                    }
                }
            }
    }

    public static void main(String[] args) {
        int dist[][] = 
        
        {{0, 4, 108, 5, 108}, {108, 0, 1, 108, 6}, 
        {2, 108, 0, 3, 108}, {108, 108, 1, 0, 2}, 
        {1, 108, 108, 4, 0}};
 floydWarshall(dist);

 for (int i = 0; i < dist.length; i++) {
    for (int j = 0; j < dist.length; j++) {
        System.out.print(dist[i][j] +" ");
    }
    
 }
    }
}
