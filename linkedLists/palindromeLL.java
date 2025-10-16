package linkedLists;

public class palindromeLL {
     public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;

        head.next = null;

        return newHead;

    }
    public  static boolean isPalindrome(ListNode head) {
         ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // store the node for future run to reverse
        ListNode mid = reverseList(slow.next); 
        ListNode t1 = head;
        ListNode t2 = mid;

        while (t2 != null) {
            if (t1.val != t2.val) {
                reverseList(mid);
                return false;
            } 
                t1 = t1.next;
                t2 = t2.next;
            
        }

        reverseList(mid);

        return true;
    }

    public static void main(String[] args) {
          int[] arr = {1, 2, 3, 3, 2,1};

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);

        boolean ans = isPalindrome(head);
        System.out.println(ans);

       


    }

}
