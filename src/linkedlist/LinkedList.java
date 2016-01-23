package linkedlist;

/**
 * Created by moheet-dev on 1/12/2016.
 */
public class LinkedList {

    public Node head;

    public LinkedList() {

    }

    public LinkedList(int value) {
        head = new Node(value);
    }

    public LinkedList(Node node) {
        this.head = node;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "\t");
            current = current.next;
        }
        System.out.println();
    }

    public void reverseIterative() {

        Node p = head;
        Node q = null;
        Node r;
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;
    }

    public void reverseRecursive(Node current) {
        if (current == null) {
            return;
        }

        reverseRecursive(current.next);

        if (current != null && current.next == null) {
            head = current;
            return;
        }

        current.next.next = current;
        current.next = null;
    }

    public void add(int value) {

        if (head == null) {
            head = new Node(value);
        }
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public void addAll(int[] array) {
        for(int element : array) {
            add(element);
        }
    }

}
