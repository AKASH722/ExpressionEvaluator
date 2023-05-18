package stack;

public class Stack {
    public char[] stack;
    public int top;
    public Stack(int size) {
        stack = new char[size];
        top=-1;
    }

    public void push(char input) {
        stack[++top]=input;
        //display();
    }

    public char pop() {
        return stack[top--];
    }
    void display() {
        for(int i = top ;i >=0 ;i--) {
            System.out.println(stack[i]);
        }
    }
}
