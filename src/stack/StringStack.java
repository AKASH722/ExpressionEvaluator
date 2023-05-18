package stack;

import MAIN.Options;
import exceptions.InvalidExpression;

public class StringStack {
    public String[] stack;
    public int top;
    public StringStack(int size) {
        stack = new String[size];
        top=-1;
    }

    public void push(String input) {
        stack[++top]=input;
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
