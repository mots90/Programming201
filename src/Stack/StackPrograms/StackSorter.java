package stack.stackPrograms;

import stack.Stack;

/**
 * Created by moheet-dev on 1/23/2016.
 */
public class StackSorter {

    private Stack unsortedStack;

    public StackSorter() {
        unsortedStack = new Stack();
    }

    public Stack sortTheStack() {
        Stack sortedStack = new Stack();

        while (!unsortedStack.isEmpty()) {

            int temp = unsortedStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() >= temp) {
                unsortedStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        return sortedStack;
    }

    public void pushAll(int [] elements) {
        for (int element : elements) {
            unsortedStack.push(element);
        }
    }

    public static void main(String[] args) {
        StackSorter sorter = new StackSorter();
        int[] elements = {3,1,4,5,2};
        sorter.pushAll(elements);
        System.out.println(sorter.sortTheStack().toString());
    }

}
