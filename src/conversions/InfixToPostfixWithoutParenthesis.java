package conversions;

import stack.Stack;

public class InfixToPostfixWithoutParenthesis extends Conversions {
    String postfix;
    String input;
    int rank;
    public Stack stack;
    public InfixToPostfixWithoutParenthesis(String input) {
        postfix = "";
        rank = 0;
        stack = new Stack(input.length());
        stack.push('#');
        super.input=input;
        this.input=input+"#";
    }
    public void convert() {
        int i=0;
        while(input.charAt(i)!='#') {
            checkAndPush(input.charAt(i++));
        }
        do {
            postfix += stack.pop();
        } while(stack.stack[stack.top]!='#');
        output = postfix;
    }
    public void checkAndPush(char next) {
        if(next == '$' || next == '^') {
            while(precedence(next) < precedence(stack.stack[stack.top])) {
                char temp = stack.pop();
                postfix += temp;
            }
        } else {
            while(precedence(next) <= precedence(stack.stack[stack.top])) {
                char temp = stack.pop();
                postfix += temp;
            }
        }
        stack.push(next);
    }
    public int precedence(char input) {
        if (input == '#') {
            return 0;
        } else if (input == '+' || input == '-') {
            return 1;
        } else if (input == '*' || input == '/') {
            return 2;
        } else if (input == '$' || input == '^') {
            return 3;
        } else {
            return 5;
        }
    }
}