import java.util.ArrayList;
import java.util.List;

public class reorederRoutes {
    public static int dfs(int i, List<List<int[]>> adjLs, int n, int[][] connections, boolean vis[]) {
        vis[0] = true;
        int changecount = 0;

        for (int[] node : adjLs.get(i)) {

            int nextNode = node[0];
            int cost = node[1];
            if (!vis[nextNode]) {
                changecount += cost;
                dfs(nextNode, adjLs, changecount, connections, vis);
            }

        }

        return changecount;
    }

    public int minReorder(int n, int[][] connections) {

        List<List<int[]>> adjLs = new ArrayList<>();

        for (int[] con : connections) {
            int a = con[0];
            int b = con[1];
            adjLs.get(a).add(new int[] { b, 1 }); // original edge
            adjLs.get(b).add(new int[] { 1, 0 }); // reversed edge

        }
        boolean vis[] = new boolean[n];
        return dfs(0, adjLs, n, connections, vis);

    }

}
