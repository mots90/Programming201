package stack.StackPrograms;

import stack.Stack;

/**
 * Created by moheet-dev on 1/22/2016.
 */
public class StackDemo {

    public static void main (String[] args) {

        Stack stack = new Stack();

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("this was expected " + e.getMessage());
        }

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        System.out.println(stack.peek());

        try {
            stack.push(11);
        } catch (IllegalStateException e) {
            System.out.println("this was expected "+e.getMessage());
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+ "\t");
        }
    }

}
