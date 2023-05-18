package stack;

import options.Options;
import exceptions.InvalidExpression;

public class StringStack {
    public String[] stack;
    public int top;
    public StringStack(int size) {
        stack = new String[size];
        top=-1;
    }

    public void push(String input) {
        try {
            if(top>=stack.length-1) {
                throw new InvalidExpression("Invalid input expression type");
            } else {
                stack[++top]=input;
            }
        } catch(InvalidExpression e){
            System.out.println(e.getMessage());
            Options.options();
        }
    }

    public String pop() {
        try {
            if(top==-1) {
                throw new InvalidExpression("Invalid input expression type");
            } else {
                return stack[top--];
            }
        } catch(InvalidExpression e){
            System.out.println(e.getMessage());
            Options.options();
            return "";
        }
    }
}
