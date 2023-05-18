package MAIN;

import conversions.*;
import exceptions.InvalidExpression;


import java.util.Scanner;

public class Options {
    static Conversions expression;
    static Scanner scanner =  new Scanner(System.in);
    public static void options() {
        System.out.println("""
             
             * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\s
             *  Press 0 --> Exit                                       *
             *  Press 1 --> Infix to PostFix(Reverse Polish)           *
             *  Press 2 --> Infix to PreFix(Polish)                    *
             *  Press 3 --> PostFix(Reverse Polish) to Infix           *
             *  Press 4 --> PreFix(Polish) to Infix                    *
             *  Press 5 --> PostFix(Reverse Polish) to PreFix(Polish)  *
             *  Press 6 --> PreFix(Polish) to PostFix(Reverse Polish)  *
             * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * \s
             """);
        String choice =  scanner.nextLine();
        switch (choice) {
            case "0" -> System.exit(0);
            case "1","2","3","4","5","6" -> {
                String input = getInput();
                switch (choice) {
                    case "1" -> expression = new InfixToPostfix(input);
                    case "2" -> expression = new InfixToPrefix(input);
                    case "3" -> expression = new PostfixToInfix(input);
                    case "4" -> expression = new PrefixToInfix(input);
                    case "5" -> expression = new PostfixToPrefix(input);
                    case "6" -> expression = new PrefixToPostfix(input);
                }
                expression.convert();
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
                expression.display();
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            }

            default -> System.out.println("Invalid input");

        }
        options();
    }
    static String getInput() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("* Enter an expression : ");
        String input = scanner.next().trim();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
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
        try {
            if (rank != 1 || input.length() == 1 || count_open != count_close) {
                throw new InvalidExpression("Invalid Expression");
            }
        } catch (InvalidExpression e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            options();
        }
        scanner.nextLine();
        return input;
    }
}
