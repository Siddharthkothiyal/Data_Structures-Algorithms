package linkedLists;

public class findStartPointinLL {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
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
ListNode startNode= detectCycle(head);

        if (startNode != null) {
            // Find the index of cycle start
            int index = 0;
            ListNode temp = head;
            while (temp != startNode) {
                temp = temp.next;
                index++;
            }
            System.out.println("Cycle starts at index " + index + " with node value: " + startNode.val);
        } else {
            System.out.println("No cycle detected.");
        }
       
        }
        }




