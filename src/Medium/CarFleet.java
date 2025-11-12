package Medium;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // If there is only one car, it is a fleet
        if (position.length == 1) return 1;

        // Create a stack to keep track of the time of cars in the fleet
        Stack<Double> stack = new Stack<>();
        // Create an array to store the position and speed of each car
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        // Sort the cars based on their positions in ascending order
        Arrays.sort(cars, java.util.Comparator.comparingInt(a -> a[0]));

        // Iterate through cars from the end and calculate the currentTime of each car
        for (int i = n - 1; i >= 0; i--){
            double currentTime = (double)(target - cars[i][0]) / cars[i][1];

            // If the current stack is not empty and the currentTime is less than the top of the stack,
            // it means the current car is part of the same fleet as the car on top of the stack
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                // Otherwise, add the currentTime to the stack
                stack.push(currentTime);
            }
        }
        // The size of the stack represents the number of fleets
        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();

        // Test case 1
        int target1 = 12;
        int[] position1 = {10,8,0,5,3};
        int[] speed1 = {2,4,1,1,3};
        System.out.println(carFleet.carFleet(target1, position1, speed1));
    }
}
