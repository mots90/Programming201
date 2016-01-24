package stack.stackPrograms;

import stack.GenericStackUnchecked;

/**
 * Created by moheet-dev on 1/22/2016.
 */
public class StackDemoUnchecked {

    public static void main (String[] args) {

        GenericStackUnchecked stack = new GenericStackUnchecked();

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("this was expected " + e.getMessage());
        }

        stack.push("11");
        stack.push("21");
        stack.push("31");
        stack.push("41");
        stack.push("51");
        stack.push("61");
        stack.push("71");
        stack.push("81");
        stack.push("91");
        stack.push("101");

        System.out.println(stack.peek());

        try {
            stack.push("111");
        } catch (IllegalStateException e) {
            System.out.println("this was expected "+e.getMessage());
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+ "\t");
        }
    }

}
