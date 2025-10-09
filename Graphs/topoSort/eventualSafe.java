import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class eventualSafe {
    public static List<Integer> eventualSafeNodes(int[][] graph) {

        // reversed graph
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[graph.length];
        // graph reversed
        for (int i = 0; i < graph.length; i++) {
            for (int it : graph[i]) {
                adjRev.get(it).add(i);
                indegree[i]++; // now edges are reversed so you need to store i
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < indegree.length; j++) {
                if (indegree[j] == 0) {
                    q.add(j);
                }
            
        }

        ArrayList<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {
            int newNode = q.peek();
            q.remove();
            safeNodes.add(newNode);

            for (int adjNode : adjRev.get(newNode)) {

                indegree[adjNode]--;
                if (indegree[adjNode] == 0)
                    q.add(adjNode);
            }

        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {

         int [][]graph = {{1,2},{2,3},{5},{0},{5},{},{}};

         ArrayList<Integer> list=new ArrayList<>(eventualSafeNodes(graph));

        ;
         for (int i = 0; i < list.size(); i++) {
           System.out.print(list.get(i) + " ");
         }
    }

}
