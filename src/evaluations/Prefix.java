package evaluations;
import conversions.Conversions;
import stack.NumberStack;

public class Prefix {
    private String prefix;
    private String temp_prefix;
    private int answer;
    private NumberStack stack;
    public Prefix(String prefix) {
        this.prefix =prefix;
        stack=new NumberStack(prefix.length());
        temp_prefix= this.prefix;
        StringBuilder temp_input = new StringBuilder(this.prefix);
        temp_input.reverse();
        this.prefix =temp_input.toString();
    }
    public void calculate() {
        int i=0;
        while(i!= prefix.length()) {
            checkAndPush(prefix.charAt(i++));
        }
        answer=stack.pop();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("* Prefix  : "+ temp_prefix);
        Conversions.getSpaces(temp_prefix);
        System.out.println();
        System.out.print("* Answer   : "+answer);
        String s= String.valueOf(answer);
        Conversions.getSpaces(s);
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

    private void checkAndPush(char c) {
        if(c>='0' && c<='9') {
            stack.push(c-'0');
        } else {
            int a = stack.pop();
            int b = stack.pop();
            int ans = 0;
            switch (c) {
                case '+' -> ans=a+b;
                case '-' -> ans=a-b;
                case '*' -> ans=a*b;
                case '/' -> ans=a/b;
                case '$','^' -> ans=(int)Math.pow(a,b);
            }
            stack.push(ans);
        }
    }
}