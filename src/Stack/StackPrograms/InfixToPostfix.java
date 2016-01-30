package stack.stackPrograms;

import stack.GenericStackUnchecked;

/**
 * Created by moheet-dev on 1/25/2016.
 */
public class InfixToPostfix extends ExpressionConversion {

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



    public static void main(String[] args) {

        InfixToPostfix converter = new InfixToPostfix();

        String infix = "A+B*C-D/E";
        String infix1 = "(A+B)*C";
        String infix2 = "A*(B+C+(D-E))";


        System.out.println("Postfix expression is " + converter.convertInfixToPostfix(infix2));

    }
}
