package Medium;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] first = new int[26], second = new int[26];

        if(s1.length() > s2.length()) return false;

        for(var ch : s1.toCharArray()) first[ch -'a']++;

        int window = s1.length() - 1;
        for (int i = 0; i < s2.length(); i++){
            second[s2.charAt(i) - 'a']++;

            if(i >= window){
                if(matches(first, second)) return true;
                second[s2.charAt(i - window) - 'a']--;
            }
        }
        return false;
    }

    private boolean matches(int[] first, int[] second){
        for(int i=0; i<26; i++) if(first[i] != second[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        // Test case 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2));

        // Test case 2
        s1 = "ab";
        s2 = "bca";
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
