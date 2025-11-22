package Medium;

/**
 * Binary search to find minimum in rotated sorted array
 * Time: O(log n), Space: O(1)
 */
public class MinInRotatedSortedArr {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left) / 2;

            // If mid > right, minimum is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // If mid <= right, minimum is in left half (including mid)
                right = mid;
            }
        }
        // When left == right, we found the minimum
        return nums[left];
    }

    public static void main(String[] args) {
        MinInRotatedSortedArr min = new MinInRotatedSortedArr();

        // Test case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(min.findMin(nums1));
    }
}
