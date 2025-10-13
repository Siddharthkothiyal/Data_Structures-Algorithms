package linkedLists;

public class reverseALL {

    static class ListNode {
        int data;
        ListNode next;

        // Constructor with both data and next node
        public ListNode(int data1, ListNode next1) {
            data = data1;
            next = next1;
        }

        // Constructor with only data
        public ListNode(int data1) {
            data = data1;
            next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;

        head.next = null;

        return newHead;

    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);

        ListNode ans =reverseList(head);
     System.out.println("Reversed Linked List is :");
     printList(ans);

    }

}
