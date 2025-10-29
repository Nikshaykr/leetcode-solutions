package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Brute force solution for Two Sum problem
 * Time: O(n²), Space: O(1)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        // Check every pair of numbers
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                // Found the target sum
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    
    /**
     * Optimized HashMap solution for Two Sum problem
     * Time: O(n), Space: O(n)
     */
    public int[] twoSumBetter(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            // Check if complement exists in map
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            // Store current number and its index
            map.put(nums[i], i);
        }
        return new int[2];
    }
    
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // Test case 1: Basic case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: [2,7,11,15], Target: 9");
        System.out.println("Output: " + java.util.Arrays.toString(solution.twoSumBetter(nums1, target1)));
        
        // Test case 2: Numbers at end
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("\nInput: [3,2,4], Target: 6");
        System.out.println("Output: " + java.util.Arrays.toString(solution.twoSumBetter(nums2, target2)));
        
        // Test case 3: Same number twice
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("\nInput: [3,3], Target: 6");
        System.out.println("Output: " + java.util.Arrays.toString(solution.twoSumBetter(nums3, target3)));
    }
}
