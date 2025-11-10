package Medium;

import java.util.Stack;

public class EvaluateRevPolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateRevPolishNotation solution = new EvaluateRevPolishNotation();

        // Test case 1
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        int result1 = solution.evalRPN(tokens1);
        System.out.println("Result 1: " + result1);

        // Test case 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = solution.evalRPN(tokens2);
        System.out.println("Result 2: " + result2);
    }
}
