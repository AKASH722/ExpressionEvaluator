package exceptions;

public class InvalidExpression extends Exception {
    public InvalidExpression(String error_msg) {
        super(error_msg);
    }
}
