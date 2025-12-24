package trees.mediumLevel;

class ListNode {

    ListNode node;
    int val;
    ListNode left, right;

    ListNode(int data) {
        val = data;
        left = right = null;
    }

}

public class heightOfBtree {
       public int maxDepth(ListNode root) {

        if(root == null) return 0;
        int lh= maxDepth(root.left);
        int rh= maxDepth(root.right);

        return 1+Math.max(lh, rh);
        
    }


}
