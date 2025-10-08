
import java.util.List;
import java.util.Stack;

public class topoDFS {
    public static void dfs(int V, int node, int vis[], Stack<Integer> st, List<List<Integer>> adj) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(V, it, vis, st, adj);
            }
        }
        st.push(node);
    }

    public int[] topoSort(int V, List<List<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(V, i, vis, st, adj);
            }
        }

        int[] topo = new int[V];

        int index = 0;
        while (!st.isEmpty()) {
            topo[index++] = st.pop();
        }
        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = List.of(
                List.of(2, 3),
                List.of(3, 4),
                List.of(5),
                List.of(5),
                List.of(),
                List.of());
        topoDFS obj = new topoDFS();
        int[] result = obj.topoSort(V, adj);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
