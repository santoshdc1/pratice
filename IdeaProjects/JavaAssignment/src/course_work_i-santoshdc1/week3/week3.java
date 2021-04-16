package week3;

import java.util.Stack;
public class week3 {

    static int precedence(char ch)
    {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPostfix(String exp)
    {
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            /* If the scanned character is an operand, add it to output. */
            if (Character.isLetterOrDigit(c))
                result.append(c);

                /* If the scanned character is an '(', push it to the stack. */
            else if (c == '(')
                stack.push(c);

                /* If the scanned character is an ')',pop and output from the stack until an '(' is encountered. */
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result.append(stack.pop());

                stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(c)
                        <= precedence(stack.peek())){

                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    // main method
    public static void main(String[] args)
    {
        String exp = "4*(5+6)";
        String postfixExp = infixToPostfix(exp);
        System.out.println("RPN conversion: "+postfixExp);
        new week3();
        System.out.println("Evaluated value: "+ week3.evalPostfix(postfixExp));
    }
    static int evalPostfix(String exp)
    {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i < exp.length(); i++)
        {
            char ch = exp.charAt(i);

            if(Character.isDigit(ch))
                st.push(ch - '0');

            else
            {
                int value1 = st.pop();
                int value2 = st.pop();
                switch (ch) {
                    case '+' -> st.push(value2 + value1);
                    case '-' -> st.push(value2 - value1);
                    case '*' -> st.push(value2 * value1);
                    case '/' -> st.push(value2 / value1);
                }
            }
        }
        return st.pop();
    }


}