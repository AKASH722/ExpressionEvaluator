package conversions;

import stack.Stack;

public class InfixToPrefix extends Conversions{
    private String prefix;
    private String input;
    int rank;
    private Stack stack;
    public InfixToPrefix(String input) {
        prefix = "";
        rank = 0;
        stack = new Stack(input.length());
        stack.push(')');
        super.input=input;
        StringBuilder temp_input = new StringBuilder(input);
        temp_input.reverse();
        input=temp_input.toString();
        this.input=input+'(';
    }

    private int precedence(char input) {
        if (input == ')') {
            return 9;
        } else if((input == '(')) {
            return 0;
        } else if (input == '+' || input == '-') {
            return 2;
        } else if (input == '*' || input == '/') {
            return 4;
        } else if (input == '$' || input == '^') {
            return 5;
        } else {
            return 8;
        }
    }

    private int precedenceStack(char input) {
        if (input == ')' || (input == '(')) {
            return 0;
        } else if (input == '+' || input == '-') {
            return 1;
        } else if (input == '*' || input == '/') {
            return 3;
        } else if (input == '$' || input == '^') {
            return 6;
        } else {
            return 7;
        }
    }

    public void convert() {
        int i=0;
        while(i!=input.length()) {
            checkAndPush(input.charAt(i++));
        }
        StringBuilder temp_output = new StringBuilder(prefix);
        temp_output.reverse();
        output=temp_output.toString();
        if(calculateRank(output)!=1) {
            System.out.println("Conversion failed");
        }
    }

    public void checkAndPush(char next) {
        if(next=='(') {
            while(stack.stack[stack.top]!=')') {
                char temp = stack.pop();
                prefix += temp;
            }
            stack.pop();
        } else {
            while (precedence(next) < precedenceStack(stack.stack[stack.top])) {
                char temp = stack.pop();
                prefix += temp;
            }
            stack.push(next);
        }
    }
    public void display() {
        System.out.println("Infix  : "+super.input);
        System.out.println("Prefix : "+super.output);
    }
}
