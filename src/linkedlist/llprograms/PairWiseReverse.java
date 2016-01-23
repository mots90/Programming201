package linkedlist.llprograms;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 *
 * A B C D E
 * B A D C E
 * Created by moheet-dev on 1/15/2016.
 */
public class PairWiseReverse {

    public static void pairWiseReverse(LinkedList list) {

        boolean isHeadUpdated = false;
        Node current = list.head; //so that the head is not altered traversing the list
        Node previous = list.head; // so that first reversed pair should point to next reversed pair

        while (current != null && current.next != null) {

            Node temp = current.next.next;  // for swapping
            current.next.next = current; //second of the pair should point to first of the pair

            if (!isHeadUpdated) { // head should be updated only once
                list.head = current.next;
                isHeadUpdated = true;
            } else {
                previous.next = current.next; //otherwise the second of the previous  pair should point to current's next which is the first of the current reversed pair
            }

            current.next = temp;
            previous = current;
            current = temp;
        }
    }

    public static Node pairWiseReverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node temp = node.next;
        Node next = node.next.next;
        node.next.next = node;
        node.next = pairWiseReverseRecursive(next);
        return temp;
    }


    public static void main(String[] args) {

        LinkedList list;

        int[] elements = {2,3,4,5};
        list = new LinkedList(1);
        list.addAll(elements);
        list.printList();

        PairWiseReverse.pairWiseReverse(list);
        list.printList();
        list.head = PairWiseReverse.pairWiseReverseRecursive(list.head);
        list.printList();
    }


}
