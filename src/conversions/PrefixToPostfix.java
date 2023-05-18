package conversions;

public class PrefixToPostfix extends Conversions{
    private String postfix;
    private String prefix;
    private int rank;
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
        rank=calculateRank(output);
        if(rank!=1) {
            System.out.println("Conversion failed");
        }
    }

    public void display() {
        System.out.println("Prefix  : "+super.input);
        System.out.println("Postfix : "+super.output);
    }
}
