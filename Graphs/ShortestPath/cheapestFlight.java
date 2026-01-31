package Graphs.ShortestPath;

import java.util.ArrayList;
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

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class cheapestFlight {
    public  static  int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = flights.length;

        for(int i=0 ;i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        Queue<Triplet> q = new LinkedList<>();
        int dist[] = new int[n + 1];
        for (int i = 0; i < n; i++)
            dist[i] = (int) 1e9;

            dist[src]=0;

        q.add(new Triplet(0, src,0));

        while (!q.isEmpty()) {
            Triplet it = q.peek();
            int stops = it.first;
            int node =it.second;
            int cost = it.third;

            q.remove();
            if (stops > k)
                continue; // skips the iteration

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edCostWeight = iter.second;

                if (edCostWeight + cost < dist[adjNode]  && stops <=  k) {
                    dist[adjNode] = edCostWeight + cost;
                    q.add(new Triplet(stops + 1, adjNode, dist[adjNode]));
                }
            }
        }

        if (dist[dst] == (int) 1e9)
            return -1;

        return dist[dst];

    }

    public static void main(String[] args) {
 int n = 3;
 int [][] flights = {{0,1,100},{1,2,100},{0,2,500}};
 int  src = 0;
 int dst = 2;
 int k = 1;

 System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

}
