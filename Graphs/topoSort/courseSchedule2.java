import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedule2 {
     public static int[] findOrder(int numCourses, int[][] prerequisites) {

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

       int topo[]= new int[numCourses];
int i=0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++]= node;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }

        }
     if (i == numCourses) return topo;
        int[] arr = {};
        return arr;

    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { {1,0},{2,0},{3,1},{3,2}};
        int ans []= findOrder(numCourses, prerequisites);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(i +" ");
        }
    } 
}
