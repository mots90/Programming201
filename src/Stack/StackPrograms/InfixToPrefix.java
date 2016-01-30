package stack.stackPrograms;

import stack.GenericStackUnchecked;

/**
 * Created by mb033889 on 1/30/16.
 */
public class InfixToPrefix extends ExpressionConversion {

    GenericStackUnchecked<String> operandStack;

    InfixToPrefix() {
        operandStack = new GenericStackUnchecked<String>();
        operatorStack = new GenericStackUnchecked<Character>();
    }

    public String convertInfixToPrefix(String infix) {

        while (hasMoreCharacters(infix)) {

            char ch = getNextCharacter(infix);

            if (isOperand(ch)) {
                operandStack.push(new String(ch+""));
            }
            else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && hasPrecedenceOverStackTop(ch)) {
                    String s1 = operandStack.pop();
                    String s2 = operandStack.pop();
                    char c = operatorStack.pop();
                    String post = c+s2+s1;
                    operandStack.push(post);
                }
                operatorStack.push(ch);
            }
            else {
                throw new RuntimeException("please fuck off, its neither an operand nor an operator");
            }

        }

        while (!operatorStack.isEmpty()) {
            String s1 = operandStack.pop();
            String s2 = operandStack.pop();
            char c = operatorStack.pop();
            String post = c+s2+s1;
            operandStack.push(post);
        }


        String postfix = operandStack.pop();
        if(!operandStack.isEmpty()||!operatorStack.isEmpty()) {
            throw new RuntimeException("improper infix string");
        }
        return postfix;
    }

    public static void main(String[] args) {

        InfixToPrefix prefixer = new InfixToPrefix();
        String infix = "A+B*C";
        String infix1 = "A*B+C";

        System.out.println(prefixer.convertInfixToPrefix(infix1));

    }

}
