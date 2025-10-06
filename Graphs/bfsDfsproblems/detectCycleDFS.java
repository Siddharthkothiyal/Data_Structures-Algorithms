

import java.util.ArrayList;

public class detectCycleDFS {

    public static boolean dFs(int V, ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int parent) {

        vis[node] = 1;

        for (int adjNode : adj.get(node)) {

            if (vis[adjNode] == 0) {
                if (dFs(V, adj, adjNode, vis, node) == true)
                    return true;
            }
            else if (parent != adjNode) {
                return true;
            }
        }

        return false;

    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++)
            vis[i] = 0;

            // connected components
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dFs(V, adj, i, vis, V))
                    return true;
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
                { 0, 2 },
                {1,2},
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
