package conversions;

public class PostfixToPrefix extends Conversions{
    private String prefix;
    private String postfix;
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
        if(calculateRank(output)!=1) {
            System.out.println("Conversion failed");
        }
    }

    public void display() {
        System.out.print("* Postfix : "+super.input);
        getSpaces(super.input);
        System.out.println();
        System.out.print("* Prefix  : "+super.output);
        getSpaces(super.output);
        System.out.println();
    }
}
