package Medium;

public class SearchInRotatedSortedArr {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        // If left pointer is greater than right, target is not in array
        if (left > right) return -1;

        // Calculate mid and check to see if mid is target, this is alo recursion ending condition
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;

        // Check if left half is sorted
        if (nums[mid] >= nums[left]){
            // Now check if the target is int the left half
            if (nums[left] <= target && target <= nums[mid])
                return search(nums, target, left, mid - 1);
            else return search(nums, target, mid + 1, right);
        } else {
            // Check if target is in right half
            if (nums[mid] <= target && target <= nums[right])
                return search(nums, target, mid + 1, right);
            else return search(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArr search = new SearchInRotatedSortedArr();

        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search.search(nums1, 0));

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search.search(nums2, 3));
    }
}
