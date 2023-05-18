package conversions;

import stack.CharacterStack;

public class InfixToPrefix extends Conversions{
    private String prefix;
    private String infix;
    private int rank;
    private CharacterStack characterStack;
    public InfixToPrefix(String infix) {
        prefix = "";
        rank = 0;
        characterStack = new CharacterStack(infix.length());
        characterStack.push(')');
        super.input= infix;
        StringBuilder temp_input = new StringBuilder(infix);
        temp_input.reverse();
        infix =temp_input.toString();
        this.infix = infix +'(';
    }

    private int precedence(char input) {
        if (input == ')') {
            return 9;
        } else if((input == '(')) {
            return 0;
        } else if (input == '+' || input == '-') {
            return 2;
        } else if (input == '*' || input == '/') {
            return 4;
        } else if (input == '$' || input == '^') {
            return 5;
        } else {
            return 8;
        }
    }

    private int precedenceStack(char input) {
        if (input == ')' || (input == '(')) {
            return 0;
        } else if (input == '+' || input == '-') {
            return 1;
        } else if (input == '*' || input == '/') {
            return 3;
        } else if (input == '$' || input == '^') {
            return 6;
        } else {
            return 7;
        }
    }

    public void convert() {
        int i=0;
        while(i!= infix.length()) {
            checkAndPush(infix.charAt(i++));
        }
        StringBuilder temp_output = new StringBuilder(prefix);
        temp_output.reverse();
        output=temp_output.toString();
        rank=calculateRank(output);
        if(rank!=1) {
            System.out.println("Conversion failed");
        }
    }

    private void checkAndPush(char next) {
        if(next=='(') {
            while(characterStack.stack[characterStack.top]!=')') {
                char temp = characterStack.pop();
                prefix += temp;
            }
            characterStack.pop();
        } else {
            while (precedence(next) < precedenceStack(characterStack.stack[characterStack.top])) {
                char temp = characterStack.pop();
                prefix += temp;
            }
            characterStack.push(next);
        }
    }
    public void display() {
        System.out.print("* Infix   : "+super.input);
        getSpaces(super.input);
        System.out.println();
        System.out.print("* Prefix  : "+super.output);
        getSpaces(super.output);
        System.out.println();
    }
}
