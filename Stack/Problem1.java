package Stack;
/*
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * whwre N is the leangth of the given expression
 */
import java.util.Stack;

public class Problem1 {


    public static boolean  isBalanced(String expression){

    Stack<Character> stack = new Stack<Character>();

    for(int i = 0; i < expression.length(); i++){
        if (expression.charAt(i) == '(')
        {
             stack.push(expression.charAt(i));
         }
         else if (expression.charAt(i) == ')'){

            if (stack.isEmpty())
            {
                return false;
            }
            char topChar = stack.pop();

            if (expression.charAt(i) == ')' && topChar == '(')
            {
                continue;
            }
            else
            {
                return false;
            }
         }
    }
    return stack.isEmpty();
}
    
}


















    


