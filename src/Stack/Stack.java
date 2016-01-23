package Stack;

/**
 * Created by moheet-dev on 1/22/2016.
 */
public class Stack {

    private static final int STACK_SIZE = 10;
    private int [] elements;
    private int top;


    public Stack() {
        elements = new int[STACK_SIZE];
        top = 0;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full, cant push " + value + " !");
        }
        elements[top++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty, cant pop !");
        }
        return elements[--top];
    }

    public boolean isEmpty(){
        if (top == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (top == STACK_SIZE ) {
            return true;
        }
        return false;
    }

    public int peek() {
        return elements[top-1];
    }


}
