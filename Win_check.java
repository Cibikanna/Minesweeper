package Minesweeper_console_application;

class Win_check {
    public static int verifying_Board(boolean b[][]) {
        int c = 0, n = b.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!b[i][j])
                    c++;
            }
        }
        if (c == n)
            return 1;
        return 0;

    }
}