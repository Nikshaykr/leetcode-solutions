package Medium;

import java.util.*;

public class TopKFrequentElement {
    public int[] topKFrequent (int[] nums, int k){
        // Create a map to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        // Create a priority queue to store the elements based on their frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (var key : map.keySet()){
            pq.add(key);

            // if the size of the priority queue is greater than k, remove the element with the lowest frequency
            if (pq.size() > k) pq.poll();
        }

        // Create an array to store the k most frequent elements
        int[] res = new int[k];
        for (var i = k - 1; i >= 0; i--) res[i] = pq.poll();

        return res;
    }

    public int[] topKFrequentOptimized (int[] nums, int k){
        // Create a map to store the num and it's frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        // Create a List of size nums.length + 1 as the most frequency a num can have is the length of nums
        // and initialize each slot of List to an empty ArrayList
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (var i = 0; i < bucket.length; i++) bucket[i] = new ArrayList<>();

        // for each entry in map add num to bucket so bucket[frequency] is a list of nums that appear freq times
        for (var entry : map.entrySet()){
            int frequency = entry.getValue();
            bucket[frequency].add(entry.getKey());
        }

        // Create a res array of size k and iterate bucket from n down to 0, for each bucket iterate it's num and add it to res
        int[] res = new int[k];
        var index = 0;
        for (int i = bucket.length - 1; i >= 0; i--){
            for (var num : bucket[i]){
                res[index++] = num;
                if (index == k) return res;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TopKFrequentElement solution = new TopKFrequentElement();

        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequentOptimized(nums1, k1);
        System.out.println("Top " + k1 + " frequent elements is: " + java.util.Arrays.toString(result1));

        // Test case 2: Checking for any null pointer exception
        int[] nums2 = {};
        int k2 = 0;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("Top " + k2 + " frequent elements is: " + java.util.Arrays.toString(result2));
    }
}
