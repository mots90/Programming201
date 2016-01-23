package linkedlist.llprograms;

import linkedlist.DoublyLinkedList;
import linkedlist.LinkedList;

/**
 * Created by moheet-dev on 1/11/2016.
 */
public class LinkedListTester {

    public static void main(String [] args) {

        DoublyLinkedList dLList = new DoublyLinkedList();

        dLList.add(1);
        dLList.add(2);

        dLList.printFromHead();
        dLList.printFromTail();


        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();
        list.reverseIterative();
        list.printList();
        list.reverseRecursive(list.head);
        list.printList();

    }
}
