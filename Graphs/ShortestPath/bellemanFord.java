package Graphs.ShortestPath;

import java.util.Arrays;

public class bellemanFord {
public static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }

    // Example usage
    public static void main(String[] args) {
       
        int V = 5;
        int[][] edges = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};

        int src = 0;
        int[] dist = bellmanFord(V, edges, src);

        if (dist.length != 1 || dist[0] != -1) {
            for (int i = 0; i < dist.length; i++) {
                System.out.print(dist[i]+ " ");
            }
        }
    }

}
