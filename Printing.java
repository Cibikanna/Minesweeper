package Minesweeper_console_application;

class Printing {
    public static void Print_board(char[][] arr, boolean[][] g) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i == 0)
                System.out.print(" ");
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    System.out.print(i + " ");
                if (g[i][j] == true)
                    System.out.print(arr[i][j] + " ");
                else
                    System.out.print("- ");
            }
            System.out.println();
        }
    }

}