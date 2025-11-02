package Medium;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = height[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = height[i];
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    public int trapOptimized(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;

        while (left < right){
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                leftMax = Math.max(leftMax, height[++left]);
            } else {
                res += rightMax - height[right];
                rightMax = Math.max(rightMax, height[--right]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height1));
        System.out.println(solution.trapOptimized(height1));
    }
}
