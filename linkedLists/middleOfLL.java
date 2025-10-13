package linkedLists;

public class middleOfLL {

    // 👇 Define ListNode *inside* the same file
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

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);

        ListNode mid = middleNode(head);
        System.out.println("Middle Node Data: " + mid.data);
    }
}
