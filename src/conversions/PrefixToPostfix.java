package conversions;

public class PrefixToPostfix extends Conversions{
    private String postfix;
    private String prefix;
    public PrefixToPostfix(String prefix) {
        this.prefix = prefix;
        this.input= prefix;
    }
    public void convert() {
        Conversions expression = new PrefixToInfix(prefix);
        expression.convert();
        Conversions expression2 = new InfixToPostfix(expression.output);
        expression2.convert();
        this.postfix =expression2.output;
        this.output= postfix;
        if(calculateRank(output)!=1) {
            System.out.println("Conversion failed");
        }
    }

    public void display() {
        System.out.print("* Prefix  : "+super.input);
        getSpaces(super.input);
        System.out.println();
        System.out.print("* Postfix : "+super.output);
        getSpaces(super.output);
        System.out.println();
    }
}
