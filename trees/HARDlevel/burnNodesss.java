package trees.HARDlevel;

import java.util.*;

public class burnNodesss {

    // Map each node to its parent
    public static void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

    // Find target node
    public static TreeNode findTarget(TreeNode root, int start) {
        if (root == null) return null;

        if (root.val == start) return root;

        TreeNode left = findTarget(root.left, start);
        if (left != null) return left;

        return findTarget(root.right, start);
    }

    //  BFS to calculate burn time
    public static int totBurnTimeBFS(TreeNode target, Map<TreeNode, TreeNode> parentMap) {

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // left child
                if (node.left != null && !visited.contains(node.left)) {
                    burned = true;
                    visited.add(node.left);
                    q.offer(node.left);
                }

                // right child
                if (node.right != null && !visited.contains(node.right)) {
                    burned = true;
                    visited.add(node.right);
                    q.offer(node.right);
                }

                // parent
                TreeNode parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    burned = true;
                    visited.add(parent);
                    q.offer(parent);
                }
            }

            if (burned) time++;
        }

        return time;
    }

    // MAIN METHOD
    public static int timeToBurnTree(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParents(root, parentMap);

        TreeNode target = findTarget(root, start);

        return totBurnTimeBFS(target, parentMap);
    }

   

    public static void main(String[] args) {



    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    root.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(7);

    root.right.right = new TreeNode(6);
    root.right.left = new TreeNode(5);

 

    int startNode = 4;
    int time = timeToBurnTree(root, startNode);

    System.out.println("Time to burn entire tree: " + time);
}

}
