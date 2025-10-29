package Easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        // Use a hashmap to store every num in nums array
        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums){
            // Check if map contains current num, if it does then return true otherwise put that num in the map
            if (map.containsKey(num)){
                return true;
            }
            map.put(num, 1);
        }
        // If no duplicate found return false;
        return false;
    }
    
    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        
        // Test case 1: has duplicates
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("[1,2,3,1] contains duplicate: " + solution.containsDuplicate(nums1));
        
        // Test case 2: no duplicates
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("[1,2,3,4] contains duplicate: " + solution.containsDuplicate(nums2));
    }
}
