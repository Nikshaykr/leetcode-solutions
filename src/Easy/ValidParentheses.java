package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        // Populate the map with matching pairs with closing brackets as keys
        // and their corresponding opening brackets as values
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (var ch : s.toCharArray()){
            // If the current character is a closing bracket
            if (map.containsKey(ch)){
                // If the stack is empty and the top of the stack does match the current character then remove it
                if (!stack.isEmpty() && stack.peek() == map.get(ch)) stack.pop();
                else return false;
            } else {
                // If the current character is an opening bracket, push it onto the stack
                stack.push(ch);
            }
        }
        // If the stack is empty that means all the corresponding closing brackets are popped hence returning its boolean
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Test case 1
        String s1 = "[]";
        boolean result1 = solution.isValid(s1);
        System.out.println("Is valid: " + result1);

        // Test case 2
        String s2 = "({[]})";
        boolean result2 = solution.isValid(s2);
        System.out.println("Is valid: " + result2);

        // Test case 3
        String s3 = "]";
        boolean result3 = solution.isValid(s3);
        System.out.println("Is valid: " + result3);
    }
}
