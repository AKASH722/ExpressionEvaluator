package conversions;

import stack.StringStack;

public class PrefixToInfix extends Conversions{
    private String infix;
    private String prefix;
    private StringStack stack;
    public PrefixToInfix(String prefix) {
        infix = "";
        stack = new StringStack(prefix.length());
        super.input= prefix;
        StringBuilder temp_input = new StringBuilder(prefix);
        temp_input.reverse();
        prefix =temp_input.toString();
        this.prefix = prefix;
    }
    public void convert() {
        int i=0;
        while(i!= prefix.length()) {
            checkAndPush(prefix.charAt(i++));
        }
        infix=stack.pop();
        super.output=infix;
        if(calculateRank(output)!=1) {
            System.out.println("Conversion failed");
        }
    }
    private void checkAndPush(char next) {
        if(checkOperand(next)==1) {
            String a= stack.pop();
            String b= stack.pop();
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
        System.out.print("* PreFix  : "+super.input);
        getSpaces(super.input);
        System.out.println();
        System.out.print("* Infix   : "+super.output);
        getSpaces(super.output);
        System.out.println();
    }
}
