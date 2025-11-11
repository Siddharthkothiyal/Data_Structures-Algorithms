package linkedLists;

public class swapNode {



    public static ListNode swapPairs(ListNode head) {
        ListNode dummy= new ListNode(0);
        dummy.next= head;
        ListNode current= dummy;


        while(current.next!= null && current.next.next != null){

            ListNode first= current.next;
              ListNode second= current.next.next;

              first.next= second.next;
              second.next= first;
              current.next= second;


             // move the next pair
              current= first;

        }

        return dummy.next;
       

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
       
         int[] arr = { 1, 2, 3, 4, 5,6 };

        // ✅ Build linked list
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
        head.next.next.next.next = new ListNode(arr[4]);
        head.next.next.next.next.next = new ListNode(arr[5]);

        ListNode ans = swapPairs(head);
        System.out.println("Reversed Linked List is :");
        printList(ans);
    }
    
}
