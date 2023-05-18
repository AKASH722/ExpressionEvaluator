package stack;

public class CharacterStack {
    public char[] stack;
    public int top;
    public CharacterStack(int size) {
        stack = new char[size];
        top=-1;
    }

    public void push(char input) {
        stack[++top]=input;
    }

    public char pop() {
        return stack[top--];
    }
}
