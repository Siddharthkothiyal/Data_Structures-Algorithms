package linkedLists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class revereseInKgrouPS {

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static ListNode findkthNode(ListNode head, int k) {
        k -= 1;
        ListNode temp = head;
        while (temp != null && k > 0) {
            k--;

            temp = temp.next;
        }
        return temp;
    }

    public static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        
        while (temp != null) {
            
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        ListNode prevNode = null;

        while (temp != null) {
            // find the kth node
            ListNode getkthNode = findkthNode(temp, k);

            if (getkthNode == null) {
                // means its a last group

                if (prevNode != null) {
                    prevNode.next = temp;
                }

                break;

            }
            ListNode nextNode = getkthNode.next; // store the node

            getkthNode.next = null; // break the linked

            reverse(temp);

            if (temp == head) {
                head = getkthNode;
            } else {
                prevNode.next = getkthNode;
            }
            prevNode = temp;
            temp = nextNode;

        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);

        ListNode ans = reverseKGroup(head, 2);
        System.out.println("Reversed Linked List is :");
        printList(ans);

    }
}
