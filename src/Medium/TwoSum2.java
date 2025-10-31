package Medium;

import java.util.Arrays;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target) return new int[] {++left, ++right};

            if (sum > target) right--;
            else left++;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        TwoSum2 ts = new TwoSum2();

        // Test case 1
        int[] test1 = {2,7,11,15};
        int target1 = 9;
        int[] result1 = ts.twoSum(test1, target1);
        System.out.println(Arrays.toString(result1));
    }
}
