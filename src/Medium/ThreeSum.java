package Medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = threeSum.threeSum(nums1);
        System.out.println("Test case 1:");
        for (List<Integer> triplet : result1) {
            System.out.println(triplet);
        }
        System.out.println();

        // Test case 2
        int[] nums2 = {0, 0, 0};
        List<List<Integer>> result2 = threeSum.threeSum(nums2);
        System.out.println("Test case 2:");
        for (List<Integer> triplet : result2) {
            System.out.println(triplet);
        }
    }
}
