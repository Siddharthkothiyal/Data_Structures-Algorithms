package linkedLists;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

public class deleteAnode {
     public static void deleteNode(ListNode node) {
        node.val= node.next.val;
        node.next= node.next.next;
    } 

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ->" + " " );
            current = current.next;
        }
    }


    public static void main(String[] args) {
        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode nodeToDelete = head.next; 


        deleteNode(nodeToDelete);
        printList(head);
    }
}
