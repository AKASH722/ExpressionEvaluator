import conversions.InfixToPostfixWithParenthesis;
import conversions.InfixToPostfixWithoutParenthesis;
import conversions.Conversions;


import java.util.Scanner;

public class Main {
    static Conversions expression;
    static Scanner scanner =  new Scanner(System.in);
    static void options() {
        System.out.println("""
               
               Press 0 --> Exit
               Press 1 --> Infix to PostFix(Reverse Polish)
               Press 2 --> Infix to PreFix(Polish)
               Press 3 --> PostFix(Reverse Polish) to Infix
               Press 4 --> PreFix(Polish) to Infix
               Press 5 --> PostFix(Reverse Polish) to PreFix(Polish)
               Press 6 --> PreFix(Polish) to PostFix(Reverse Polish)""");
        String choice =  scanner.nextLine();
        switch (choice) {
            case "0" -> {
                return;
            }
            case "1" -> {
                String input = getInput();
                expression = new InfixToPostfixWithParenthesis(input);;
                expression.convert();
                expression.display("PostFix");
            }
            default -> {
                System.out.println("Invalid input");
            }
        }
        options();
    }
    static String getInput() {
        System.out.println("Enter an expression : ");
        String input = scanner.next().trim();
        int rank = Conversions.calculateRank(input);
        String[] in = input.split("");
        int count_open=0,count_close=0;
        for(String a : in) {
            if(a.equals("(")) {
                count_open++;
            }
            if(a.equals(")")) {
                count_close++;
            }
        }
        if(rank !=1 || input.length()==1 || count_open!=count_close) {
            System.out.println("Invalid expression");
            scanner.nextLine();
            options();
        }
        scanner.nextLine();
        return input;
    }
    public static void main(String[] args) {
        options();
    }
}