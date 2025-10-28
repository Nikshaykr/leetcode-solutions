package Easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    public boolean isPalindromeBetter(int x) {
        var characters = String.valueOf(x).toCharArray();
        var left = 0;
        var right = characters.length - 1;
        while (left < right) {
            if (characters[left] != characters[right]) return false;

            left++;
            right--;
        }
        return true;
    }
    // Time complexity: O(log n) & Space complexity: O(log n) because of string and char array storage

    public boolean isPalindromeOptimized (int x){
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
