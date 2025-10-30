package Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                var num = board[r][c];
                if (num != '.'){
                    if (    !seen.add(num + " in row " + r)    ||
                            !seen.add(num + " in column " + c) ||
                            !seen.add(num + " in block " + r/3 + "-" + c/3))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        // Test case 1: is a valid sudoku
        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board1));

        // Test case 2: is not a valid sudoku
        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board2));
    }
}
