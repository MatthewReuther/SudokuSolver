# Sudoku Solver

## Rules of Sudoku 

### Rule 1 - Each row must contain the numbers from 1 to 9, without repetitions

The player must focus on filling each row of the grid while ensuring there are no duplicated numbers. The placement order of the digits is irrelevant.

Every puzzle, regardless of the difficulty level, begins with allocated numbers on the grid. The player should use these numbers as clues to find which digits are missing in each row.

### Rule 2 - Each column must contain the numbers from 1 to 9, without repetitions

The Sudoku rules for the columns on the grid are exactly the same as for the rows. The player must also fill these with the numbers from 1 to 9, making sure each digit occurs only once per column.

The numbers allocated at the beginning of the puzzle work as clues to find which digits are missing in each column and their position.

### Rule 3 - The digits can only occur once per block (nonet)

A regular 9 x 9 grid is divided into 9 smaller blocks of 3 x 3, also known as nonets. The numbers from 1 to 9 can only occur once per nonet.

In practice, this means that the process of filling the rows and columns without duplicated digits finds inside each block another restriction to the numbers' positioning.

### Rule 4 - The sum of every single row, column and nonet must equal 45

To find out which numbers are missing from each row, column or block or if there are any duplicates, the player can simply count or flex their math skills and sum the numbers. When the digits occur only once, the total of each row, column and group must be of 45.