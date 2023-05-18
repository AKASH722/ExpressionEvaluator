package conversions;

import stack.StringStack;

public class PostfixToInfix extends Conversions{

    private String infix;
    private String postfix;
    int rank;
    private StringStack stack;
    public PostfixToInfix(String postfix) {
        infix = "";
        rank = 0;
        stack = new StringStack(postfix.length());
        super.input= postfix;
        this.postfix = postfix;
    }
    public void convert() {
        int i=0;
        while(i!= postfix.length()) {
            checkAndPush(postfix.charAt(i++));
        }
        infix=stack.pop();
        super.output=infix;
    }
    private void checkAndPush(char next) {
        if(checkOperand(next)==1) {
            String b= stack.pop();
            String a= stack.pop();
            infix = "("+a+next+b+")";
            stack.push(infix);
        } else {
            stack.push(String.valueOf(next));
        }
    }
    private int checkOperand(char input) {
        if (input == '+' || input == '-' || input == '*' || input == '/' || input == '$' || input == '^') {
            return 1;
        } else {
            return 0;
        }
    }
    public void display() {
        System.out.println("Postfix  : "+super.input);
        System.out.println("Infix    : "+super.output);
    }
}
