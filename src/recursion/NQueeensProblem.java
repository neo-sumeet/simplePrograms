package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueeensProblem {
    private static List<String[]> solutions = new ArrayList<>();

    static String[][] find_all_arrangements(int n) {

        //false means not selected
        boolean[] cols = new boolean[n];
        boolean[] lDiag = new boolean[(n*2)-1];
        boolean[] rDiag = new boolean[(n*2)-1];
        char[][] board = new char[n][n];

        for (char[] row: board) Arrays.fill(row,'-');

        solveBoard(board, 0, cols, lDiag, rDiag);


        return solutions.toArray(new String[0][0]);
    }


    private static void solveBoard(char[][] board, int row, boolean[] cols, boolean[] lDiag, boolean[] rDiag) {

        if (row == board.length) {

            String[] solvedBoard = new String[board.length];

            int solvedRow = 0;

            for (char[] currRow: board) {
                solvedBoard[solvedRow++] = String.valueOf(currRow);
            }

            solutions.add(solvedBoard);

        } else {

            for (int col = 0; col < cols.length; col++) {
                if (selectCol(row,col,cols,lDiag,rDiag)) {

                    board[row][col] = 'q';

                    solveBoard(board,row + 1, cols, lDiag, rDiag);

                    board[row][col] = '-';

                    deselectCol(row,col,cols,lDiag,rDiag);
                }
            }

        }
    }

    private static boolean selectCol(int row, int col, boolean[] cols, boolean[] lDiag, boolean[] rDiag) {

        if (!cols[col] && ! lDiag[row + col] && !rDiag[row + cols.length-1 - col]) {
            cols[col] = true;
            lDiag[row + col] = true;
            rDiag[row + cols.length-1 - col] = true;
            return true;
        } else {
            return false;
        }
    }

    private static void deselectCol(int row, int col, boolean[] cols, boolean[] lDiag, boolean[] rDiag) {
        cols[col] = false;
        lDiag[row + col] = false;
        rDiag[row + cols.length-1 - col] = false;
    }

    public static void main(String[] args) {
        String[][] all_arrangements = find_all_arrangements(4);
        for (String[] arrangement : all_arrangements) {
            for (String row : arrangement) {
                System.out.println(row);
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");        }



    }
}

