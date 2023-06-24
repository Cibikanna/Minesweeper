package Minesweeper_console_application;

class Extend_spaces {
    public static int Visit_Is_Mines(char board[][], int row, int col) {
        int count = 0;
        int n = board.length;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && board[i][j] == '*')
                    count++;
            }
        }
        return count;
    }

    public static void visitAdjacentCells(char[][] board, int row, int col, boolean[][] g) {
        int n = board.length;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && !g[i][j]) {
                    g[i][j] = true;
                    if (board[i][j] == '-') {
                        int adjacentMines = Visit_Is_Mines(board, i, j);
                        board[i][j] = (char) (adjacentMines + ' ');
                        if (adjacentMines == 0)
                            visitAdjacentCells(board, i, j, g);
                    }
                }
            }
        }
    }
}
