package linkedLists;

public class merge2LL {
        ListNode sortedMerge(ListNode head1, ListNode head2) {
           // code here
      ListNode dummy = new ListNode(0);
    ListNode res = dummy;
       ListNode t1= head1;
       ListNode t2= head2;
       while(t1!= null && t2!= null){
           if(t1.val < t2.val){
               res.next= t1;
               res= t1;
               t1= t1.next;
           }
           else{
               res.next= t2;
               res= t2;
               t2= t2.next;
           }
           res.next=null;
       }
    
    if(t1 != null) res.next=t1;
     if(t2 != null) res.next=t2;
     
     return dummy.next;
        
    }
    
}
