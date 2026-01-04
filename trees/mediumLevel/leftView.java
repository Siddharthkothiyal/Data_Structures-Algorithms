package trees.mediumLevel;

import java.util.ArrayList;
import java.util.List;

public class leftView {
    public static void leftSide(TreeNode node,ArrayList<Integer> list , int level) {
    

        if (node == null)
            return;

        if (list.size() == level) {
            list.add(node.val);
        }

        leftSide(node.left,list, level + 1);
        leftSide(node.right,list, level + 1);

    }

    public static List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        leftSide(root,list, 0);

        return list;

    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(8);

        ArrayList<Integer> ans = new ArrayList<>(leftSideView(root));

        for (int i = 0; i < ans.size(); i++) {

            System.out.println(ans.get(i));

        }
    }
}
