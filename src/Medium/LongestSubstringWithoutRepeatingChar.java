package Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        // Create a set for O(1) lookups and initialize left pointer to 0 and assume maxLength to be 0 as well
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        // Start a for loop with right pointer and check if the char at right is already present in the set
        for (int right = 0; right < s.length(); right++) {
            // If it is the remove the prev characters until we don't have any duplicates
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // If not then add that char to the set and update the maxLength everytime
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar solution = new LongestSubstringWithoutRepeatingChar();

        // Test case 1
        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
