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

        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("Solved Successfully!");
        } else {
            System.out.println("Unsolvable board!");
        }
        printBoard(board);

    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            //for every third row and if the row is not = to 0 print ---
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {

                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
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

    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, number, row, column);
    }

    //main algorithm
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0 ) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            //Call board again recursively,
                            //traverses the entire grid and find the next "blank" spot
                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}