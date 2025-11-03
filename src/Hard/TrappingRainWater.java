package Hard;
/**
 * Two-pointer approach for trapping rainwater
 * Time: O(n), Space: O(1)
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        // Two pointers from both ends
        int left = 0, right = height.length - 1;
        // Track max heights seen so far from each side
        int leftMax = height[left], rightMax = height[right];
        int totalWater = 0;

        while (left < right){
            // Move pointer with smaller max height
            if (leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                // Water trapped = min(leftMax, rightMax) - current height
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                // Water trapped = min(leftMax, rightMax) - current height
                totalWater += rightMax - height[right];
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result1 = solution.trap(height1);
        System.out.println("Total trapped water: " + result1);
    }
}
