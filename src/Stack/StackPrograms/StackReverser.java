package stack.StackPrograms;

import stack.Stack;

/**
 *
 * Reverse the stack without using additional data structure.
 *
 * Created by moheet-dev on 1/23/2016.
 */
public class StackReverser {

    private Stack stack;

    public StackReverser() {
        stack = new Stack();
    }

    public void reverseStack() {

        if (this.stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverseStack();
        insertAtBottom(top);
    }

    public void insertAtBottom(int value) {
        if(stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(value);
        stack.push(temp);
    }


    public void pushAll(int [] elements) {
        for (int element : elements) {
            stack.push(element);
        }
    }

    public static void main(String[] args) {
        StackReverser reverser = new StackReverser();

        int[] elements = {1,2,3,4,5};
        reverser.pushAll(elements);
        reverser.print();
        reverser.reverseStack();
        reverser.print();
    }

    private void print() {
        System.out.println(this.stack.toString());
    }
}
