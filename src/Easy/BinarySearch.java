package Easy;

public class BinarySearch {
    public int searchIterative(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public int searchRecursive(int[] nums, int target) {
        return searchRecursive(nums, target, 0, nums.length - 1);
    }

    private int searchRecursive(int[] nums, int target, int left, int right){
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return searchRecursive(nums, target, mid + 1, right);
        else return searchRecursive(nums, target, left, mid - 1);
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        // Test case 1
        int[] nums = new int[] {-1,0,3,5,9,12};
        System.out.println(solution.searchIterative(nums, 9));

        // Test case 2
        System.out.println(solution.searchRecursive(nums, 9));

    }
}
