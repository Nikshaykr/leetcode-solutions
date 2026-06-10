package Medium;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        /* The first approach that comes to mind would be to sort each word and make the sortedWord a key for
        *  a map, then check if the word corresponding to this key exists in the map, if not then initialize the value
        *  of that key to an empty list, if it does then add the current word to it, finally return map.values.
        */
        Map<String, List<String>> map = new HashMap<>();

        for (var word : strs) {
            // You convert every word to a charArray then sort it
            char[] sWord = word.toCharArray();
            Arrays.sort(sWord);

            // Then again convert that sorted word to a string and check if the key exist in the map as a key,
            // if it does then add the current word to this list, if not then initialize a new list as this key's value
            var key = Arrays.toString(sWord);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (var word : strs){
            // For every word in our current string we create an array name count
            int[] count = new int[26];

            // For every character in that word we increment the count of occurrence of that char in count array
            // and convert it to a string. Basically populate the count array acc to curr word.
            for (var ch : word.toCharArray()) count[ch - 'a']++;
            var key = Arrays.toString(count);
            // Here for example for first word (act), the string key would contain all 0s but 1s at the index of 'a',
            // 'c' and 't' then we put the key of 1a, 1c and 1t with the current word as its value.

            // For next word for ex would be car the key would contain all 0s except 1a, 1c and 1t,
            // as we already have this key in our map we will add the current word to the arraylist for this key.
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        // Return the values of the map that are the arraylist that have anagrams of each other into a single arraylist
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        // Test case 1 Better approach
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = groupAnagrams.groupAnagrams(strs1);
        System.out.println(result1);

        // Test case 2 Brute force approach
        String[] strs2 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result2 = groupAnagrams.groupAnagramsBruteForce(strs1);
        System.out.println(result2);
    }
}
