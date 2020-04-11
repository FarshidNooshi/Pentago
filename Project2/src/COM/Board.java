// In The Name Of GOD
package COM;

public class Board implements ColorfulText {
    private SubBoard[][] table;

    Board() {
        table = new SubBoard[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                table[i][j] = new SubBoard();
    }

    SubBoard getTable(int x, int y) {
        return table[x][y];
    }

    boolean occupied(int row, int column) {
        return table[row / 3][column / 3].get(row % 3, column % 3).userNumber != -1;
    }

    void rotateClockwise(int x, int y) {
        this.table[x][y].rotateClockwise();
    }

    void rotateCounterClockwise(int x, int y) {
        table[x][y].rotateCounterClockwise();
    }

    void print(Game game) {
        System.out.println(ANSI_GREEN + empty + " is empty");
        for (int i = 0; i < game.getNumberOfPlayers(); i++)
            System.out.println(game.getPlayer(i).getPlayerCell().getColor() + game.getPlayer(i).getPlayerCell().type + " is for player " + i);
        System.out.print(ANSI_PURPLE);
        for (int i = 0; i < 7; i++) {
            if (i == 4)
                System.out.print(" ");
            if (i != 0)
                System.out.print("  " + i);
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(ANSI_PURPLE + (i + 1));
            for (int j = 0; j < 6; j++) {
                table[i / 3][j / 3].get(i % 3, j % 3).print();
                if (j == 2)
                    System.out.print(" ");
            }
            System.out.println();
            if (i == 2)
                System.out.println();
        }
        System.out.print(ANSI_RESET);
    }

    boolean hasWinner(Game game) {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 1; j++) {
                boolean is = true;
                for (int k = 1; k < 5; k++)
                    if (!table[i / 3][j / 3].get(i % 3, j % 3).equals(table[i / 3][(j + k) / 3].get(i % 3, (j + k) % 3)))
                        is = false;
                if (is && table[i / 3][j / 3].get(i % 3, j % 3).getType() != empty) {
                    game.getPlayer(table[i / 3][j / 3].get(i % 3, j % 3).userNumber).setWinner();
                    return true;
                }
            }
        for (int j = 0; j < 6; j++)
            for (int i = 0; i < 1; i++) {
                boolean is = true;
                for (int k = 1; k < 5; k++)
                    if (!table[i / 3][j / 3].get(i % 3, j % 3).equals(table[(i + k) / 3][j / 3].get((i + k) % 3, j % 3)))
                        is = false;
                if (is && table[i / 3][j / 3].get(i % 3, j % 3).getType() != empty) {
                    game.getPlayer(table[i / 3][j / 3].get(i % 3, j % 3).userNumber).setWinner();
                    return true;
                }
            }

        for (int row = 0; row < 2; row++)
            for (int column = 4; column < 6; column++) {
                boolean is = true;
                Cell tmp = table[row / 3][column / 3].get(row % 3, column % 3);
                for (int k = 1; k < 5 && is; k++) {
                    if (!tmp.equals(table[(row + k) / 3][(column - k) / 3].get((row + k) % 3, (column - k) % 3)))
                        is = false;
                }
                if (is && tmp.userNumber != -1) {
                    game.getPlayer(table[row / 3][column / 3].get(row % 3, column % 3).userNumber).setWinner();
                    return true;
                }
            }

        for (int row = 0; row < 2; row++)
            for (int column = 0; column < 2; column++) {
                boolean is = true;
                Cell tmp = table[row / 3][column / 3].get(row % 3, column % 3);
                for (int k = 1; k < 5 && is; k++) {
                    if (!tmp.equals(table[(row + k) / 3][(column + k) / 3].get((row + k) % 3, (column + k) % 3)))
                        is = false;
                }
                if (is && tmp.userNumber != -1) {
                    game.getPlayer(table[row / 3][column / 3].get(row % 3, column % 3).userNumber).setWinner();
                    return true;
                }
            }
        return false;
    }
}