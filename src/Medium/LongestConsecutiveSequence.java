package Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive (int[] nums){

        // Initialize the longest length to 1 and create a map to store each number with the value of boolean (false)
        // to track if it's visited or not
        int longestLength = 1;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, Boolean.FALSE);
        }

        for (var num : nums){
            var currentLength = 1;

            // For each num in nums array check for the number next to it's sequence
            var nextNum = num + 1;
            while (map.containsKey(nextNum) && map.get(nextNum) == false){
                currentLength++;
                map.put(nextNum, true);
                nextNum++;
            }

            // For each num in nums array check for the number previous to it's sequence
            var prevNum = num - 1;
            while (map.containsKey(prevNum) && map.get(prevNum) == false){
                currentLength++;
                map.put(prevNum, true);
                prevNum--;
            }

            // Update the longestLength
            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }
    // Time complexity: O(n) && Space complexity: O(n) (Hashmap Storage)

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums1));

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums2));
    }
}
