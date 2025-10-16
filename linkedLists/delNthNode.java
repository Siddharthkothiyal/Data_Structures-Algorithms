package linkedLists;

public class delNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len == n) return head.next;
    
        temp = head;
        for (int i = 1; i < len - n; i++) {
            temp = temp.next;
        }

        // Step 4: Delete the nth node from end
        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }

     public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->" + "");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
         // Create linked list: 4 -> 5 -> 1 -> 9
         int n = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
         head.next.next.next.next = new ListNode(5);

        printList(removeNthFromEnd(head, n));
    }
}
