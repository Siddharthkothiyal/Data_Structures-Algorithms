package Graphs.bfsDfsproblems;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Queue;

class Pair {
    int first;
    int second;

    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }

}

public class detectCycle {

    // check using bfs is there any cycle
    // check for connected components
    // vis [] , parent of node
    // if(parent ! = adjNode) 6-7 and 7 is already visided by 5 in this case
    // there are two node accessing the same node with multiple parents

    // bfs function

    public static boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int node, int[] vis) {

        vis[node] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        while (!q.isEmpty()) {
            int qnode = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for (int adjNode : adj.get(qnode)) {
                if (vis[adjNode] == 0) {
                    q.add(new Pair(adjNode, qnode));
                    vis[adjNode] = 1;
                }

                else if (adjNode != parent) {
                    // If neighbor is visited and not parent => cycle
                    return true;
                }

            }
        }

        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++)
            vis[i] = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (vis[i] == 0) {
                    if (bfs(V, adj, i, vis) == true)
                        return true;
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 4; // number of vertices

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        int[][] edges = {

                { 0, 1 },
                { 1,2 }, // creates a cycle between 0-1-2
                { 2, 3 },
               

        };
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        System.out.println(isCycle(V, adj));

    }
}
