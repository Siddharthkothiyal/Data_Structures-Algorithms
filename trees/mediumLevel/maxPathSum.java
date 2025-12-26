package trees.mediumLevel;

public class maxPathSum {
       public static int maxDepth(TreeNode root, int[] diameter) {

        if (root == null)
            return 0;
     int lh = Math.max(0, maxDepth(root.left, diameter));
int rh = Math.max(0, maxDepth(root.right, diameter));


        diameter[0] = Math.max(diameter[0], rh + lh+ root.val);
        return root.val + Math.max(lh, rh);

    }
     public static int maxpathSum(TreeNode root) {

        int diameter[] = new int[1];
        diameter[0]= Integer.MIN_VALUE;
        maxDepth(root, diameter);
        return diameter[0];
        
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.right= new TreeNode(8);
        root.left= new TreeNode(4);
        root.left.left= new TreeNode(-11);
        root.left.left.left= new TreeNode(7);
        root.left.left.right= new TreeNode(-2);


        
        root.right.right= new TreeNode(4);
        root.right.left= new TreeNode(13);


int ans = maxpathSum(root);

System.out.println(ans);



        
    }
}
