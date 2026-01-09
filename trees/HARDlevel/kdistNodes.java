package trees.HARDlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class kdistNodes {

    public static void parentTrack(TreeNode root, Map<TreeNode, TreeNode> trackParentsMap) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                trackParentsMap.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {

                trackParentsMap.put(node.right, node);
                q.offer(node.right);

            }

        }

    }

    public static List<Integer> bfsToKdist(TreeNode root, TreeNode target, int k, Map<TreeNode, TreeNode> trackParentsMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);

        int distance = 0;
        while (!q.isEmpty()) {

            int size = q.size();

            if (distance ++ == k) {
                break;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);

                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }

                if (trackParentsMap.containsKey(node) && !visited.contains(trackParentsMap.get(node))) {
                    visited.add(trackParentsMap.get(node));
                    q.offer(trackParentsMap.get(node));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    public  static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if (root == null)
            return new ArrayList<>();

        Map<TreeNode, TreeNode> mp = new HashMap<>();

        parentTrack(root, mp);

        return bfsToKdist(root, target, k, mp);

    }

    public static void main(String[] args) {
  // Construct the binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left; 
        int k = 2;
        List<Integer> result = distanceK(root, target, k);
        // Print the result
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

}
