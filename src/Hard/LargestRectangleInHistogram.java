package Hard;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights){
        int n = heights.length, maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++){
            int currElement = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currElement){
                int h = heights[stack.pop()];
                int prevSmaller = (stack.isEmpty()) ? -1 : stack.peek();
                int w = i - prevSmaller - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return (maxArea == Integer.MIN_VALUE) ? 0 : maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        // Test case 1
        int[] heights = new int[] {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(heights));
    }
}
