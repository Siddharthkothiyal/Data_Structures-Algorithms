package linkedLists;

public class loopDetect {
    public  static boolean hasCycle(ListNode head) {

        ListNode slow=head;
        ListNode fast= head;

        while(fast!= null && fast.next!= null){
            slow= slow.next;
            fast = fast.next.next;

            if(slow== fast){
                return true;
            }
        }

        return false;
        
    }
      public static void main(String[] args) {
        int[] arr = {3,2,0,-4};

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = head.next;
       

boolean ans = hasCycle(head);
System.out.println(ans);
    }
}
