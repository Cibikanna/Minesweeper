package Minesweeper_console_application;

class Placeing_mines {
    public static char[][] place(char[][] a) {
        int m = a.length;
        a = randommines(a, m);
        return a;
    }

    public static char[][] randommines(char[][] a, int l) {
        // uncomment the below line for make game easy
        // int m = (int)Math.floor(l/2);
        int m = a.length;
        for (int i = m - 1; i >= 0; i--) {
            int num1 = (int) Math.floor(Math.random() * (l));
            int num2 = (int) Math.floor(Math.random() * (l));

            if (a[num1][num2] == '-')
                a[num1][num2] = '*';
            else {
                num1 = (int) Math.floor(Math.random() * (l));
                num2 = (int) Math.floor(Math.random() * (l));
                a[num1][num2] = '*';
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                int num1 = i, num2 = j;
                if (a[num1][num2] == '*')
                    continue;
                else {
                    int temp = 0;
                    if (num1 != 0 && num2 != 0 && a[num1 - 1][num2 - 1] == '*')
                        temp++;
                    if ((num1 != l - 1 && num2 != l - 1)) {
                        if (a[num1 + 1][num2 + 1] == '*')
                            temp++;
                    }

                    if (num1 != l - 1 && a[num1 + 1][num2] == '*')
                        temp++;
                    if (num2 != l - 1 && a[num1][num2 + 1] == '*')
                        temp++;

                    if (num1 != 0 && a[num1 - 1][num2] == '*')
                        temp++;
                    if (num2 != 0 && a[num1][num2 - 1] == '*')
                        temp++;

                    if (num1 != l - 1 && num2 != 0 && a[num1 + 1][num2 - 1] == '*')
                        temp++;
                    if (num1 != 0 && num2 != l - 1 && a[num1 - 1][num2 + 1] == '*')
                        temp++;

                    if (temp != 0)
                        a[num1][num2] = Integer.toString(temp).charAt(0);
                }
            }
        }
        return a;
    }
}
