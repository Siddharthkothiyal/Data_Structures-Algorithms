package linkedLists;

public class interSection {
       public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if (headA == null || headB== null)  return null;
        ListNode t1 = headA;
        ListNode t2 = headB;

        while(t1!=t2){
            t1= t1.next;
            t2= t2.next;

            //if they both get matched
            if(t1== t2) return t1;

            //if any both of them gets Exhausted then
            if(t1== null) t1= headB;
            if(t2== null) t2= headA;
        } 
        return t1;
    }

public static void main(String[] args) {
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(9);

        // First list
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = intersect;

        // Second list
        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = intersect;

        // Get intersection node
        ListNode ans = getIntersectionNode(headA, headB);

        if (ans != null)
            System.out.println("Intersection Node value: " + ans.val);
        else
            System.out.println("No intersection found");
}
}
