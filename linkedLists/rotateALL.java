package linkedLists;

public class rotateALL {

     public  static ListNode findNthNode(ListNode temp , int k){
        int count=1;
        while(temp!=null){
            if(count==k) return temp;
                count++;
                temp=temp.next;
        }

        return temp;
    }
     public static ListNode rotateRight(ListNode head, int k) {
       if(head==null || k==0 ) return head;

        ListNode tail=head;
        int len = 1;

        //to  find the length of the linked lists
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }

        if(k%len==0) return head;

        k=k%len;
//connect tail of linked list to head
        tail.next=head;

//new Last node after rotating the linked lists
        ListNode newLastNode = findNthNode(head ,len-k);
        head=newLastNode.next;

        //make sure that node pointing to null
        newLastNode.next=null;

        return head;
    }
     public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ->" + " " );
            current = current.next;
        }
    }


    public static void main(String[] args) {

        int k=2;
           ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        printList(rotateRight(head, k));



    }
}
