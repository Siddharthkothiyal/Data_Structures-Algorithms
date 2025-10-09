package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.PriorityQueue;

// 1-2-3-4-5
//1-2=1
//1-3= 2
//2-3=1
//3-4=1
//4-5= 1
//3-5=3

// 4

// time complexity will be the 0(n* m) +  o(n)+ o(logn)dist // multiple egeds are there 
// space complexit (0(1)) dist(1);
class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class dijkstraAlgo {
    public static int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int dist[] = new int[V];
      
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
         
        }

        dist[src] = 0;
   

        // pq will store the Src node and The dist as 0
        pq.add(new Pair(src, 0));

        while (pq.size() != 0) {
            int node = pq.peek().first;
            int dis = pq.peek().second;
            pq.remove();

          for (Pair iter : adj.get(node)) {
            int adjNode = iter.first;
            int edW= iter.second;
             if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(adjNode,dist[adjNode]));
          }
        }

    }
    return dist;
}

    public static void main(String[] args) {
       int V = 5;
       int edges[][] = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
       int src = 0;

       int result[] = dijkstra(V, edges, src);

       for (int i : result) {
        System.out.print(i + " ");
       }
    }
}
