package Medium;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums){
        int zeroCount = 0;
        int product = 1;
        
        // Count zeros and calculate product of non-zero elements
        for (var num : nums) {
            if (num == 0) zeroCount++;
            else product *= num;
        }
        
        int[] result = new int[nums.length];
        for (var i = 0; i < nums.length; i++){
            if (zeroCount > 1) {
                result[i] = 0; // More than one zero
            } else if (zeroCount == 1) {
                result[i] = nums[i] == 0 ? product : 0; // Only zero position gets product
            } else {
                result[i] = product / nums[i]; // No zeros, safe division
            }
        }
        return result;
    }

    public int[] productExceptSelfOptimized(int[] nums){
        // Create two array of size same as nums to store left and right multiplications
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 4, 6};
        int[] result1 = solution.productExceptSelfOptimized(nums1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test case 2
        int[] nums2 = {0, 0};
        int[] result2 = solution.productExceptSelfOptimized(nums2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
