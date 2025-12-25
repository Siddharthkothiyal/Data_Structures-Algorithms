package trees.mediumLevel;

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

public class balanceCheck {

    public static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        int lh = maxDepth(root.left);

        if (lh == -1) {
            return -1;
        }
        int rh = maxDepth(root.right);

        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);

    }

    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        if (isBalanced(root)) {
            System.out.println("Tree is Balanced");
        } else {
            System.out.println("Tree is not Balanced");

        }
    }

}
