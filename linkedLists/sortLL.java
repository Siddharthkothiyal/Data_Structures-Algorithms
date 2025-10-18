package linkedLists;

import java.util.Arrays;

public class sortLL {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // find len
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // copy values put it into the arr

        int i = 0;
        temp = head;
        int arr[] = new int[len];
        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }

        Arrays.sort(arr);
        // put values in ll
        temp = head;
        i = 0;
        while (temp != null) {
            temp.val = arr[i++];
            temp = temp.next;
        }

        return head;

    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ->" + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        printList(sortList(head));
    }
}
