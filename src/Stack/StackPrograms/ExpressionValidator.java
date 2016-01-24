package stack.stackPrograms;

import stack.GenericStackUnchecked;

/**
 * Created by moheet-dev on 1/23/2016.
 */
public class ExpressionValidator {

    GenericStackUnchecked<Character> stack;

    public ExpressionValidator() {
        stack = new GenericStackUnchecked<Character>();
    }

    public boolean isValid(String expression) {

        for (char c : expression.toCharArray()) {

            if (c == '(' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' ) {
                if(stack.peek() == null) {
                    return false;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
            else if (c == '}' ) {
                if(stack.peek() == null) {
                    return false;
                }
                if (stack.peek() == '{') {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

        String expression1 = "()()()";
        String expression2 = "(())";
        String expression3 = "({}{})";
        String expression4 = "(())(";
        String expression5 = ")(())";

        String[] expressionArray = {expression1,expression2,expression3,expression4,expression5};

        for (String expression : expressionArray) {

            ExpressionValidator validator = new ExpressionValidator();

            if (validator.isValid(expression)) {
                System.out.println(expression + " : valid aahe !!");
            } else {
                System.out.println(expression + " : valid nahiye !!");
            }

        }

    }

}
