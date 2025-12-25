package trees.mediumLevel;


public class diameterBtree {

    public static int maxDepth(TreeNode root, int[] diameter) {

        if (root == null)
            return 0;
        int lh = maxDepth(root.left, diameter);
        int rh = maxDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], rh + lh);
        return 1 + Math.max(lh, rh);

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        int diameter[] = new int[1];

        maxDepth(root, diameter);

        return diameter[0];

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        root.right.left.left.left = new TreeNode(9);
        root.right.right.right.right = new TreeNode(8);

        int diameter = diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }

}
