package Medium;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        // Initialize a freq array to store the frequency of each character, left pointer, maxFreq and maxWindow
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxWindow = 0;

        for (int right = 0; right < s.length(); right++){
            // Update the freq of the current char
            freq[s.charAt(right) - 'A']++;

            // Update the maxFreq and calculate the current window length
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int currentWindow = right - left + 1;

            // If the window is not valid, then shrink the window
            if (currentWindow - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Calculate the new currentWindow and update the maxWindow
            currentWindow = right - left + 1;
            maxWindow = Math.max(maxWindow, currentWindow);
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        LongestRepeatingCharReplacement solution = new LongestRepeatingCharReplacement();

        // Test case 1
        String s1 = "ABAB";
        int k1 = 2;
        int result1 = solution.characterReplacement(s1, k1);
        System.out.println(result1);
    }
}
