package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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

public class levelorder {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root == null) {
            return list;
        }
        q.offer(root);

        while (!q.isEmpty()) {
            int subSize = q.size();
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < subSize; i++) {

                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);

                subList.add(q.poll().val);
            }
            list.add(subList);
        }

        return list;

    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        List<List<Integer>> result =  levelOrder(root);

        System.out.println("Level Order Traversal is : ");

       for (List<Integer> level : result) {
         for (int i = 0; i < level.size(); i++) {
            System.out.print(level.get(i));
         }
       }

        


    }

}
