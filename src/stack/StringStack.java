package stack;

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
        return stack[top--];
    }
}
