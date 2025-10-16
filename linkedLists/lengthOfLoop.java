package linkedLists;

public class lengthOfLoop {

    public static int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {

                int len = 1;
                fast=fast.next;
                while (slow != fast) {
                    len++;
                    fast = fast.next;
                }
                return len;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 7, 8, 9 };

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);
        head.next.next.next.next.next.next = new ListNode(arr[6]);
        head.next.next.next.next.next.next.next = new ListNode(arr[7]);
        head.next.next.next.next.next.next.next.next = head.next.next;

        int ans = findLengthOfLoop(head);
        System.out.println(ans);
    }
}
