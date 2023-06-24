package Minesweeper_console_application;

import java.util.Scanner;
import Minesweeper_console_application.*;

public class Minesweeper extends Placing_mines {

    public static int n;

    public static void main(String[] args) {
        Printing display = new Printing();// creating the object for printing
        Win_check win_or_not = new Win_check();// creating object for check the player is win or not
        Extend_spaces visit_spaces = new Extend_spaces();// object for extending the spaces
        Scanner sc = new Scanner(System.in);
        /*
         * //For dynamic board under size 11 uncomment this lines
         * System.out.print("Enter the board size: ");
         * n = sc.nextInt();
         */

        n = 9;
        int mines = (int) Math.floor(n / 2);

        System.out.println("The sample board is shown below:");
        char board[][] = new char[n][n];
        boolean Boolean_board[][] = new boolean[n][n];
        char sample[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sample[i][j] = '-';
                Boolean_board[i][j] = true;
            }
        }
        display.Print_board(sample, Boolean_board);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '-';
                Boolean_board[i][j] = false;
            }
        }
        board = place(board);

        // Plese uncomment the following lines for answer board

        /*
         * for (int i = 0; i < n; i++) {
         * for (int j = 0; j < n; j++) {
         * Boolean_board[i][j] = true;
         * }
         * }
         * display.Print_board(board, Boolean_board);
         * for (int i = 0; i < n; i++) {
         * for (int j = 0; j < n; j++) {
         * Boolean_board[i][j] = false;
         * }
         * }
         */
        Play_Game p = new Play_Game();
        p.Play(board, Boolean_board);

    }
}
