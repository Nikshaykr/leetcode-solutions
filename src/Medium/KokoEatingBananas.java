package Medium;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // Initialize two pointers named min and maxSpeed set minSpeed to 1 as the least speed can be 1
        // and maxSpeed to the largest int in piles
        int minSpeed = 1, maxSpeed = 0;
        for (int pile : piles) maxSpeed = Math.max(maxSpeed, pile);

        // Use binary search and find the mid
        while (minSpeed < maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            // Create a private method to calculate the total hours needed to eat all bananas at the current speed
            // Eventually both the pointers will point to one same int which would be our answer
            if (canEatInTime(piles, h, mid)) maxSpeed = mid;
            else minSpeed = mid + 1;
        }
        return minSpeed;
    }

    public boolean canEatInTime(int[] piles, int h, int speed){
        int hours = 0;
        for (int pile : piles) hours += (int) Math.ceil((double) pile / speed);
        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();

        // Test case 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(koko.minEatingSpeed(piles1, h1));

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(koko.minEatingSpeed(piles2, h2));


    }
}
