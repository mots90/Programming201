package linkedlist.llprograms;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Created by moheet-dev on 1/17/2016.
 *
 * 1 2 3 4 5
 * 1 5 2 4 3
 */
public class FirstToLastToSecondToSecondLast {

    public static void firstToLastToSecondToSecondLast(LinkedList list) {

        Node slow = list.head;
        Node fast = slow;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedList list2 = new LinkedList(slow.next);
        list2.reverseIterative();
        slow.next = null;

        Node head1 = list.head;
        Node head2 = list2.head;

        while (head1 != null && head2 != null) {

            Node temp1 = head1.next;
            Node temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }


    }

    public static void main(String[] args)  {

        LinkedList list = new LinkedList();
        int[] array = {1,2,3,4,5};
        list.addAll(array);
        list.printList();
        FirstToLastToSecondToSecondLast.firstToLastToSecondToSecondLast(list);
        list.printList();
    }
}
