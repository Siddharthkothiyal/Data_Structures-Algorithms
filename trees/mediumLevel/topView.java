package trees.mediumLevel;

import java.util.*;

class Pair {
    TreeNode first;
    int second;

    Pair(TreeNode _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

public class topView {

    public static List<Integer> topview(TreeNode root) {

        List<Integer> ansList = new ArrayList<>();
        if (root == null) return ansList;

        Queue<Pair> q = new LinkedList<>();

        // TreeMap to maintain sorted order of verticals
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair it = q.poll();
            TreeNode node = it.first;
            int vertical = it.second;

            // store first node of each vertical
            if (!map.containsKey(vertical)) {
                map.put(vertical, node.val);
            }

            if (node.left != null) {
                q.offer(new Pair(node.left, vertical - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, vertical + 1));
            }
        }

        // Extract in sorted order
        for (int val : map.values()) {
            ansList.add(val);
        }

        return ansList;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        List<Integer> result = topview(root);

        System.out.print("Top View Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
