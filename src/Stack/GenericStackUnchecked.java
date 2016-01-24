package stack;

/**
 * Created by moheet-dev on 1/22/2016.
 */
public class GenericStackUnchecked<T> {

    private static final int STACK_SIZE = 10;
    private Object [] elements;
    private int top;


    public GenericStackUnchecked() {
        elements =  new Object[STACK_SIZE];
        top = 0;
    }

    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("stack is full, cant push " + value + " !");
        }
        elements[top++] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty, cant pop !");
        }
        return (T) elements[--top];
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

    public T peek() {
        if (!isEmpty())
            return (T)elements[top-1];
        return null;
    }


}
