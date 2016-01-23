package linkedlist;

/**
 * Created by moheet-dev on 1/11/2016.
 */
public class DoublyLinkedList {

    DLLNode head = null;
    DLLNode tail = null;

    public DoublyLinkedList() {
    }

    public void printFromHead() {
        while(head != null) {
            System.out.print(head.value + "\t");
            head = head.next;
        }
        System.out.println();
    }

    public void printFromTail() {
        while (tail != null) {
            System.out.print(tail.value + "\t");
            tail = tail.previous;
        }
        System.out.println();
    }

    public void add(int value) {

        DLLNode current = head;
        DLLNode DLLNode = new DLLNode(value);

        if (current != null) {
            while (current.next != null) {
                current = current.next;
            }
            current.next = DLLNode;
            DLLNode.previous = current;
        }
        else {
            head = DLLNode;
        }

        tail = DLLNode;
    }
}
