package linkedLists;

class Node {
    public int data;
    public Node next;

    // Constructor with both data and next node
    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data (assuming next is initially null)
    public Node(int data1) {
        data = data1;
        next = null;
    }
}

public class insertionLL {

    // Insert at front
    public static Node insertAtFront(Node head, int x) {
        Node temp = new Node(x, head);
        return temp;
    }

    // Insert at last
    public static Node insertAtLast(Node head, int x) {
        Node addedNode = new Node(x); // ❌ fixed: was (x, head)
        if (head == null) return addedNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = addedNode;
        return head;
    }

    // Insert at any k-th position
    public static Node insertAtAnyPoint(Node head, int x, int k) {
        Node addedNode = new Node(x); // ❌ fixed: was (x, head)

        if (k == 1) {
            addedNode.next = head;
            return addedNode;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < k - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds!");
            return head;
        }

        addedNode.next = current.next;
        current.next = addedNode;

        return head;
    }

    // Print list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        Node head = null;

        // insert at head
        head = insertAtFront(head, 30);
        head = insertAtFront(head, 20);
        head = insertAtFront(head, 10);
        System.out.println("After insertAtFront:");
        printList(head);

        // insert at tail
        head = insertAtLast(head, 40);
        head = insertAtLast(head, 50);
        System.out.println("\nAfter insertAtLast:");
        printList(head);

        // insert at position k
        head = insertAtAnyPoint(head, 25, 3);
        head = insertAtAnyPoint(head, 5, 1);
        head = insertAtAnyPoint(head, 60, 8);
        System.out.println("\nAfter insertAtAnyPoint:");
        printList(head);
    }
}
