package stack;

import exceptions.InvalidExpression;
import options.Options;

public class NumberStack {
    public int[] stack;
    public int top;
    public NumberStack(int size) {
        stack = new int[size];
        top=-1;
    }
    public void push(int input) {
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

    public int pop() {
        try {
            if(top==-1) {
                throw new InvalidExpression("Invalid input expression type");
            } else {
                return stack[top--];
            }
        } catch(InvalidExpression e){
            System.out.println(e.getMessage());
            Options.options();
            return 0;
        }
    }
}
