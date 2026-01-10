package trees.HARDlevel;

public class countNodes {
    public static int countNodess(TreeNode root) {
     

        if (root == null)
            return 0;

        int lf = countNodess(root.left);

        int rf = countNodess(root.right);

        return 1+ lf+rf;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        // node.left = new TreeNode(2);
        // node.right = new TreeNode(3);
        // node.right.left = new TreeNode(6);

        // node.left.left = new TreeNode(4);
        // node.left.right = new TreeNode(5);

        System.out.println(countNodess(node));

    }
}
