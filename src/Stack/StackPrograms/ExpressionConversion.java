package stack.stackPrograms;

import stack.GenericStackUnchecked;

/**
 * Created by mb033889 on 1/30/16.
 */
public abstract class ExpressionConversion {

    private int charIndex = 0;

    GenericStackUnchecked<Character> operatorStack;

    char getNextCharacter(String string) {
        return (charIndex < string.length()) ? string.toCharArray()[charIndex++] : '#';
    }

    boolean hasMoreCharacters(String string) {
        return (charIndex < string.length() ) ? true : false;
    }

    boolean isOperand(char ch) {
        return ((ch >= 'A' && ch <='Z') || (ch >= 'a' && ch <='z')) ? true: false;
    }

    boolean isOperator(char ch) {
        return ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || ch == '(' || ch == ')') ? true: false;
    }

    boolean doesStackTopHavePrecedenceOverCh(char ch) {
        if(operatorStack.isEmpty()) {
            return false;
        }

        if(operatorStack.peek() == ')' || ch == ')') {
            return true;
        }
        if (ch == '(' || operatorStack.peek() == '(') {
            return false;
        }



        char stackTop = operatorStack.peek();
        if (ch == '+' ) {
            if (stackTop == '*' || stackTop == '/') {
                return true;
            }
            else {
                return false;
            }
        }
        if (ch == '+' ) {
            if (stackTop == '*' || stackTop == '/') {
                return true;
            }
            else {
                return true;
            }
        }
        if (ch == '*' || ch == '/') {
            if (stackTop == '+' || stackTop == '-') {
                return false;
            }
            else {
                return false;
            }
        }

        return true;

    }

}
