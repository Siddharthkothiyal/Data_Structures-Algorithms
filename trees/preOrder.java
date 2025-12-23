package trees;

class ListNode {

    ListNode node;
    int val;
    ListNode left, right;

    ListNode(int data) {
        val = data;
        left = right = null;
    }

}

public class preOrder {

    public static void preorder(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);

    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);

        node.left = new ListNode(2);
        node.right = new ListNode(3);
        node.left.left = new ListNode(4);
        node.right.right = new ListNode(5);

System.out.println("Preorder Traversal is : ");
     preorder(node);

    }

}
