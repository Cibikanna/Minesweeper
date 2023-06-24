package Minesweeper_console_application;

import java.util.Scanner;

class Play_Game {
    public static void Play(char[][] board, boolean[][] Boolean_board) {
        Scanner sc = new Scanner(System.in);
        Printing display = new Printing();
        Extend_spaces visit_spaces = new Extend_spaces();
        Win_check win_or_not = new Win_check();

        int t = 0;
        while (true) {
            if (t == 0) {
                System.out.println("\nEnter the row and coloumn to open(For eg 2 and 3): ");
                t = 1;
            } else
                System.out.println("\nEnter the row and coloumn to open: ");
            int row = 0, col = 0;
            try {
                row = sc.nextInt();
                col = sc.nextInt();
                if (Boolean_board[row][col]) {
                    System.out.println("The cell is already visited");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Enter the  valid row or coloumn");
                continue;
            }

            if (board[row][col] == '*') {
                Boolean_board[row][col] = true;
                display.Print_board(board, Boolean_board);
                System.out.print("You detonated a Mine! GAME OVER!");
                break;
            } else {
                if (board[row][col] != '-') {
                    Boolean_board[row][col] = true;
                    display.Print_board(board, Boolean_board);
                } else {
                    visit_spaces.visitAdjacentCells(board, row, col, Boolean_board);
                    display.Print_board(board, Boolean_board);
                }
                int f = win_or_not.verifying_Board(Boolean_board);
                if (f == 1) {
                    System.out.print("Congrats you wins!");
                    break;
                }
            }
        }
    }
}
