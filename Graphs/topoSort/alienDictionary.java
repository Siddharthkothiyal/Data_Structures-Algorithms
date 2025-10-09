import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class alienDictionary {
  public static List<Integer> topoSort(int V, List<List<Integer>> adj) {
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
    ArrayList<Integer> topo = new ArrayList<>();

    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();
      topo.add(node);

      for (int adjNode : adj.get(node)) {
        inDegree[adjNode]--;
        if (inDegree[adjNode] == 0) {
          q.add(adjNode);
        }
      }
    }
    if (topo.size() < V) {
         return null;  // indicate cycle
      }

      return topo;
  }

  public static String findOrder(String[] words) {

   

    // get the no. of unique characters as K

     Set<Character> chars = new HashSet<>();
    for (String w : words) {
      for (char c : w.toCharArray()) chars.add(c);
    }

    int V = chars.size();


     List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      int len = Math.min(word1.length(), word2.length());

      for (int j = 0; j < len; j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
          break;
        }
      }
    }
    List<Integer> orderOFDict = topoSort(V, adj);

    StringBuilder ans = new StringBuilder();
    for (int i : orderOFDict) ans.append((char) (i + 'a'));

    return ans.toString();
  }

  public static void main(String[] args) {

    String[] words = { "bdbc" ,"dbe", "bcebc", "e", "bedb" };
    System.out.println(findOrder(words)+ " ");
  }
}
