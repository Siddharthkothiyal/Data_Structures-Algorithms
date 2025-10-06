
import java.util.ArrayList;

public class noOfProvinces {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node) {
        //dfs for checking adjacent nodes
    
        vis[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] == 0) {
                dfs(adj, vis, adjNode);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adjLs.add(new ArrayList<>());
        }
        // convert adj matrix to adj list

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] vis = new int[isConnected.length];

        for (int i = 0; i < vis.length; i++) {
            vis[i] = 0;
        }

        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (vis[i] == 0) {
                count++;
                dfs(adjLs, vis, i);
            }
        }

        return count;

    }

    public static void main(String[] args) {
int isConnected[][]= {{1,1,0},{1,1,0},{0,0,1}};

System.out.println(findCircleNum(isConnected));
    }
}
