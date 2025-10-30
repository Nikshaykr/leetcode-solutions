package Easy;

public class ValidPalindrome {
    public boolean isPalindrome (String s){
        // Remove every character that is non-alphabetical
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    public boolean isPalindromeOptimized(String s){
        // Create left and right pointers
        int i = 0, j = s.length() - 1;
        while (i < j){
            // Move the pointer towards each other if the current character is non-alphabetical
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            // Check if both char at left and right are equal, if not then return false otherwise move the pointer towards each other
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();

        // Test cases
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindromeOptimized("A man, a plan, a canal: Panama"));
    }
}
