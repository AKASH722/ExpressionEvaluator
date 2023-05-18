package evaluations;
import conversions.Conversions;
import stack.NumberStack;

public class Postfix {
    private String postfix;
    private int answer;
    private NumberStack stack;
    public Postfix(String postfix) {
        this.postfix=postfix;
        stack=new NumberStack(postfix.length());
    }
    public void calculate() {
        int i=0;
        while(i!= postfix.length()) {
            checkAndPush(postfix.charAt(i++));
        }
        answer=stack.pop();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("* Postfix  : "+postfix);
        Conversions.getSpaces(postfix);
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
            int b = stack.pop();
            int a = stack.pop();
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