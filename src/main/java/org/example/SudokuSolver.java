package org.example;

public class SudokuSolver {

    //Create constant because we are going to be referencing the 9by9 grid a lot
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        //Create a 2 dimensional array 9 by 9 grid board
        //With zeros as your placeholder for "blank"
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        System.out.println("Hello world!");
    }

    //Helper classes
    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i =0; i < GRID_SIZE; i++) {
            if (board[row][i] == number ) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i =0; i < GRID_SIZE; i++) {
            if (board[i][column] == number ) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;

        for (int r = localBoxRow; r < localBoxRow + 3; r++) {
            for (int c = localBoxColumn; c < localBoxColumn + 3; c++) {
                if (board[r][c] == number ) {
                    return true;
                }
            }
        }
        return false;
    }
    

}