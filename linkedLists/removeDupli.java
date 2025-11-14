package linkedLists;

public class removeDupli {
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;
        ListNode prevNode = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (prevNode.val != temp.val) {
                prevNode.next = temp;
                prevNode = temp;
            }

            temp = temp.next;
        }

        prevNode.next = null;
        return head;

    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6 };

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);
        head.next.next.next.next.next.next = new ListNode(arr[6]);
        head.next.next.next.next.next.next.next= new ListNode(arr[7]);
        head.next.next.next.next.next.next.next.next = new ListNode(arr[8]);
        head.next.next.next.next.next.next.next.next.next = new ListNode(arr[9]);

        ListNode ans = deleteDuplicates(head);
        System.out.println("new Linked List is :");
        printList(ans);

    }
}
