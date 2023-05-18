package conversions;

public class PostfixToPrefix extends Conversions{
    private String prefix;
    private String postfix;
    private int rank;
    public PostfixToPrefix(String postfix) {
        this.postfix=postfix;
        this.input=postfix;
    }
    public void convert() {
        Conversions expression = new PostfixToInfix(postfix);
        expression.convert();
        Conversions expression2 = new InfixToPrefix(expression.output);
        expression2.convert();
        this.prefix=expression2.output;
        this.output=prefix;
        rank=calculateRank(output);
        if(rank!=1) {
            System.out.println("Conversion failed");
        }
    }

    public void display() {
        System.out.println("Postfix : "+super.input);
        System.out.println("Prefix  : "+super.output);
    }
}
