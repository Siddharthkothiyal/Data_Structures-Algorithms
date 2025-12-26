package trees.mediumLevel;

public class sameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args) {
        // Tree 1
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        // Tree 2 (same as Tree 1)
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

        // Tree 3 (different structure)
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);

        System.out.println("Tree1 vs Tree2: " + isSameTree(t1, t2));
        System.out.println("Tree1 vs Tree3: " + isSameTree(t1, t3));
    }
}
