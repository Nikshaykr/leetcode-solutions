package Easy;

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
}
