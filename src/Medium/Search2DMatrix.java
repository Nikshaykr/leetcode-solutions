package Medium;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target){
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols-1;

        while (row < rows && col > -1){
            int curr = matrix[row][col];
            if(curr == target) return true;
            else if(curr > target) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix search = new Search2DMatrix();

        // Test case 1
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target1 = 3;
        System.out.println(search.searchMatrix(matrix1, target1));
    }
}
