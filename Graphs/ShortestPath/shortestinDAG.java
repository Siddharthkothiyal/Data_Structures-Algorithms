package Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Stack;

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class shortestinDAG {

    public static void dfs(int node,
            ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;

            if (vis[v] == 0) {
                dfs(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] dist = new int[N];
        int vis[] = new int[N];

        for (int i = 0; i < N; i++) {
            dist[i] = (int) 1e9;
            vis[i] = 0;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, st);
            }
        }

        dist[0]=0;
        while (!st.isEmpty()) {
            int node=st.peek();
            st.pop();
            for(int i=0 ; i< adj.get(node).size() ; i++){
                     int adjNode = adj.get(node).get(i).first;
                     int wt= adj.get(node).get(i).second;

                     if(dist[node] + wt < dist[adjNode]){
                        dist[adjNode]=dist[node] + wt;
                     }
            }
            
        }
for(int i=0 ; i< dist.length ; i++){
    if(dist[i]== (int) 1e9){
    dist[i] = -1;
    }
}
        
return dist;
    }

    public static void main(String[] args) {
         int N = 6;
         int  M = 7;
         int [][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

         int[] result = shortestPath(N, M, edge);

         for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
         }
    }
}
