package conversions;

import stack.Stack;

public class InfixToPostfix extends Conversions{
    private String postfix;
    private String input;
    int rank;
    private Stack stack;
    public InfixToPostfix(String input) {
        postfix = "";
        rank = 0;
        stack = new Stack(input.length());
        stack.push('(');
        super.input=input;
        this.input=input+')';
    }

    private int precedence(char input) {
        if (input == ')') {
            return 0;
        } else if((input == '(')) {
            return 9;
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

    private int precedenceStack(char input) {
        if (input == ')' || (input == '(')) {
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

    public void convert() {
        int i=0;
        while(i!=input.length()) {
            checkAndPush(input.charAt(i++));
        }
        output = postfix;
        if(calculateRank(output)!=1) {
            System.out.println("Conversion failed");
        }
    }

    public void checkAndPush(char next) {
        if(next==')') {
            while(stack.stack[stack.top]!='(') {
                char temp = stack.pop();
                postfix += temp;
            }
            stack.pop();
        } else {
            while (precedence(next) < precedenceStack(stack.stack[stack.top])) {
                char temp = stack.pop();
                postfix += temp;
            }
            stack.push(next);
        }
    }
    public void display() {
        System.out.println("Infix   : "+input);
        System.out.println("Postfix : "+output);
    }
}
