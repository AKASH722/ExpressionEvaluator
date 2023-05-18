package conversions;

public  abstract class Conversions {
    String input;
    String output;
    static int rank(char input) {
        if(input=='+' || input=='-' || input=='*' || input =='/'|| input=='$' || input =='^') {
            return -1;
        } else if (input=='#' || input =='(' || input==')') {
            return 0;
        } else {
            return 1;
        }
    }

    public static int calculateRank(String input) {
        int rank=0;
        for (int i = 0; i < input.length(); i++) {
            rank+=rank(input.charAt(i));
        }
        return rank;
    }
    public abstract void convert();

    public abstract void display();

    public static void getSpaces(String input) {
        int length=47-input.length()-1;
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
    }
}
