import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
int m = prerequisites.length;
        for(int i=0 ;i<m ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

       ArrayList<Integer> topo= new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }

        }
        if (topo.size() == numCourses) return true;

        return false;

    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 }};
        System.out.println(canFinish(numCourses, prerequisites));
    }

}
