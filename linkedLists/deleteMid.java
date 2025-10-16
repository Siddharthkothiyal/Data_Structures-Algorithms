package linkedLists;

public class deleteMid {
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = head;

        while (temp != null) {
            if (temp.next == slow) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
printList(deleteMiddle(head));

    }
}
