package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    public int lengthOfLongestSubstringOptimal(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            if (map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar solution = new LongestSubstringWithoutRepeatingChar();

        // Test case 1
        String input1 = "abcabcbb";
        int result1 = solution.lengthOfLongestSubstring(input1);
        System.out.println("Length of the longest substring without repeating characters: " + result1);

        // Test case 2
        String input2 = "pwwkew";
        int result2 = solution.lengthOfLongestSubstring(input2);
        System.out.println("Length of the longest substring- " + input2 + " without repeating characters: " + result2);

        // Test case 3
        String input3 = "abcabcbb";
        int result3 = solution.lengthOfLongestSubstringOptimal(input3);
        System.out.println("Length of the longest substring without repeating characters: " + result3);
    }
}
