package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public int[] topKFrequent (int[] nums, int k){
        // Create a map to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();

        for (var num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

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

    public static void main(String[] args) {
        TopKFrequentElement solution = new TopKFrequentElement();

        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("Top " + k1 + " frequent elements is: " + java.util.Arrays.toString(result1));

        // Test case 2: Checking for any null pointer exception
        int[] nums2 = {};
        int k2 = 0;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("Top " + k2 + " frequent elements is: " + java.util.Arrays.toString(result2));
    }
}
