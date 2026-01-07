package trees.mediumLevel;

public class symmetric {
    public static boolean isSymmetrichelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return (left.val == right.val)
                && isSymmetrichelp(left.left, right.right) && isSymmetrichelp(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return isSymmetrichelp(root.left, root.right);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);

        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);

        boolean ans = isSymmetric(node);
        System.out.println(ans);

    }

}
