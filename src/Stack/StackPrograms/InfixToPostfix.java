package stack.stackPrograms;

import stack.GenericStackUnchecked;

/**
 * Created by moheet-dev on 1/25/2016.
 */
public class InfixToPostfix {


    private int charIndex = 0;

    GenericStackUnchecked<Character> operatorStack;

    InfixToPostfix() {
        operatorStack = new GenericStackUnchecked<Character>();
    }

    public String convertInfixToPostfix (String infix) {
        StringBuffer postfix = new StringBuffer();

        while ( hasMoreCharacters(infix)) {

            char ch = getNextCharacter(infix);

            if (isOperand(ch)) {
                postfix.append(ch);
            }
            else if (isOperator(ch)) {
                    while(!operatorStack.isEmpty() && hasPrecedenceOverStackTop(ch) && operatorStack.peek() != '(') {
                        postfix.append(operatorStack.pop());
                    }
                    if(operatorStack.isEmpty())
                        operatorStack.push(ch);
                    else if (ch != ')') {
                        operatorStack.push(ch);
                    } else {
                        operatorStack.pop();
                    }
            }
            else {
                throw new RuntimeException("please fuck off, invalid infix expression");
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    private char getNextCharacter(String string) {
        return (charIndex < string.length()) ? string.toCharArray()[charIndex++] : '#';
    }

    private boolean hasMoreCharacters(String string) {
        return (charIndex < string.length() ) ? true : false;
    }

    private boolean isOperand(char ch) {
        return ((ch >= 'A' && ch <='Z') || (ch >= 'a' && ch <='z')) ? true: false;
    }

    private boolean isOperator(char ch) {
        return ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || ch == '(' || ch == ')') ? true: false;
    }

    private boolean hasPrecedenceOverStackTop(char ch) {
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


    public static void main(String[] args) {

        InfixToPostfix converter = new InfixToPostfix();

        String infix = "A+B*C-D/E";
        String infix1 = "(A+B)*C";
        String infix2 = "A*(B+C+(D-E))";


        System.out.println("Postfix expression is " + converter.convertInfixToPostfix(infix2));

    }
}
