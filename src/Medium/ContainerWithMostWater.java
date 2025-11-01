package Medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        // Initialize left and right pointer and assume maxArea to be 0
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // While left pointer does not cross right pointer calculate the area of the current rectangle formed by
        // the left and right pointer by formula area of rectangle = length * breadth, and update the maxArea
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            // If the left height is lesser or equal to the right height move the left pointer inward to find a higher height
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea1 = solution.maxArea(height1);
        System.out.println("Max area: " + maxArea1);
    }
}
