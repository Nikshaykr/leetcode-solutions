package Easy;

import java.util.Arrays;

public class ValidAnagram {

    // Brute force approach is to sort both array and return true if both are equal
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
    // Time complexity: O(n logn + m logm) as sorting takes O(N logn) and we're sorting two arrays
    // Space complexity: O(n + m) because of the two charArrays created depending on the length of both arrays

    public boolean isAnagramOptimized(String s, String t){
        // Optimized approach is to use a hash table
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array of size 26 to store the count of each character
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // Increment the count of the character in the first string
            count[s.charAt(i) - 'a']++;
            // Decrement the count of the character in the second string
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        // Test case 1: is a valid anagram
        System.out.println(validAnagram.isAnagramOptimized("anagram", "nagaram"));

        // Test case 2: is not a valid anagram
        System.out.println(validAnagram.isAnagramOptimized("rat", "car"));
    }
}
