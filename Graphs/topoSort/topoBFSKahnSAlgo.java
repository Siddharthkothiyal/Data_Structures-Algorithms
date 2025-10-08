import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topoBFSKahnSAlgo {

    public static int[] topoSort(int V, List<List<Integer>> adj) {


        // //create a adjList

        //   List<List<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < V; i++) {
        //     adj.add(new ArrayList<>());
        // }
      
        // for(int edg[] : edges){
        //     int u =   edg[0];
        //     int v =   edg[1];
        //     adj.get(u).add(v);
        // }

        
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;

            for (int adjNode : adj.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }
return topo;
    }

    public static void main(String[] args) {
      int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int ans[] = topoSort(V, adj);

        System.out.print("Topological Sort: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
