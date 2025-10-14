package Graphs.DSUs;

import java.util.ArrayList;

public class minOpertions {

public static class DisjointSet {
        ArrayList<Integer> rank;
        ArrayList<Integer> parent;
        ArrayList<Integer> size;

        public DisjointSet(int n) {
            rank = new ArrayList<>();
            parent = new ArrayList<>();
            size = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent(int node) {

            if (parent.get(node) == node) {
                return node;
            }

            // find parent of node
            int ulp = findUParent(parent.get(node));
            // set parent of node to ultmate parent ulp
            parent.set(node, ulp);

            // return the parent
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {

            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);

            if (ulp_u == ulp_v)
                return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }

        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);

            if (ulp_u == ulp_v)
                return;

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, (size.get(ulp_u) + size.get(ulp_v)));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, (size.get(ulp_u) + size.get(ulp_v)));
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {

        DisjointSet ds = new DisjointSet(n);
        int countExtraEdges = 0;

        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (ds.findUParent(u) == ds.findUParent(v)) {
                countExtraEdges++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        int connectedCompo = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                connectedCompo++;
            }
        }
        int ans = connectedCompo - 1;
        if (countExtraEdges >= ans)
            return ans;

        return -1;

    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = { {0,1},{0,2},{0,3},{1,2} };

        System.out.println(makeConnected(n, connections));
    }

}
