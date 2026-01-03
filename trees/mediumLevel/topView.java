package trees.mediumLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;

class Pair {
    TreeNode first;
    int second;

    Pair(TreeNode _first, int _second) {

        this.first = _first;
        this.second = _second;
    }
}

public class topView {
    public List<Integer> topview(TreeNode root) {
        ArrayList<Integer> ansList = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair it = q.remove();

            TreeNode node = it.first;
            int verticle = it.second;

            if (map.get(verticle) == null)
                map.put(node.val, verticle);

            if (node.left != null) {
                q.add(new Pair(node.left, verticle-1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, verticle+1));
            }

        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {

            ansList.add(entry.getValue());
            
        }

        return ansList ;

    }

}
