package linkedLists;

public class twinSum {
    public static int pairSum(ListNode head) {

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int arr[] = new int[len];
        temp = head;
        int index = 0;

        while (temp != null) {
            arr[index++] = temp.val;   // store in order
            temp = temp.next;
        }

        int maxSum = 0;
        for (int i = 0; i < len/2; i++) {

         
                maxSum = Math.max(maxSum, arr[i] + arr[len - 1 - i]);
            
        }

        return maxSum;
    }

    public static void main(String[] args) {
           int[] arr = { 5, 4, 2, 1};

   
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);
    

        System.out.println(pairSum(head));


    }

}
