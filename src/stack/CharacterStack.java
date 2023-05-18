package stack;

import exceptions.InvalidExpression;
import options.Options;

public class CharacterStack {
    public char[] stack;
    public int top;
    public CharacterStack(int size) {
        stack = new char[size];
        top=-1;
    }

    public void push(char input) {
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

    public char pop() {
        try {
            if(top==-1) {
                throw new InvalidExpression("Invalid input expression type");
            } else {
                return stack[top--];
            }
        } catch(InvalidExpression e){
            System.out.println(e.getMessage());
            Options.options();
            return 'a';
        }
    }
}
