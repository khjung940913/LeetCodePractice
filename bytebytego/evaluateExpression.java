import java.util.Stack;

public class Main {
    public Integer evaluate_expression(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        
        String toEval = s.replace(" ", "");

        int res = 0;
        int currNumb = 0;
        int sign = 1;

        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNumb = currNumb * 10 + Character.getNumericValue(c);
            } 
            else if (c == '+' || c == '-') {
                res += currNumb * sign;
                if (c == '+') sign = 1;
                if (c == '-') sign = -1;
                currNumb = 0;
            }
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } 
            else if (c == ')') {
                res += currNumb * sign;
                res *= stack.pop();
                res += stack.pop();
                currNumb = 0;
            }
        }
        return res + currNumb*sign;
    }
}
