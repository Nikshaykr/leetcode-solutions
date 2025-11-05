package Hard;

public class MinWindowSubstr {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length())
            return "";

        int[] map = new int[128];
        int count = t.length(), start = 0, end = 0, minLength = Integer.MAX_VALUE, startIndex = 0;

        // Populate the freq map according to t
        for (char ch : t.toCharArray()) map[ch]++;

        char[] chS = s.toCharArray();
        while (end < chS.length){
            // If the character is in t, decrement the count
            if (map[chS[end++]]-- > 0) count--;

            // When all characters in t are found, start shrinking the window
            while (count == 0){
                // Update the minimum length and start index
                int currentWindow = end - start;
                if (currentWindow < minLength){
                    minLength = currentWindow;
                    startIndex = start;
                }

                // If the character at start is in t, increment the count
                if (map[chS[start++]]++ == 0) count++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        MinWindowSubstr solution = new MinWindowSubstr();

        // Test case 1
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));

        // Test case 2
        System.out.println(solution.minWindow("a", "a"));
    }
}
