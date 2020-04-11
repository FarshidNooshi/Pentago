// In The Name Of GOD
package COM;

/**
 * the Board class that contains for subBoards for implementation
 */

public class Board implements ColorfulText {
    private SubBoard[][] table;

    /**
     * it's the constructor of the class
     * we have 4 subBoards
     * each subBoard is a 3*3 cell table
     * initially each subBoard is empty
     */
    Board() {
        table = new SubBoard[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                table[i][j] = new SubBoard();
    }

    /**
     *
     * @param x is the row number of the subBoard
     * @param y is the column number of the subBoard
     * @return the subBoard of the row x and column y
     */
    SubBoard getTable(int x, int y) {
        return table[x][y];
    }

    /**
     *
     * @param row is the row number in the Game table
     * @param column is the column number in the Game table
     * @return true if the cell[row][column] is occupied by some player and is not empty
     */
    boolean occupied(int row, int column) {
        return table[row / 3][column / 3].get(row % 3, column % 3).userNumber != -1;
    }

    /**
     * rotate's the subBoard[x][y] clockwise
     * @param x a row number for subBoard
     * @param y a column number for subBoard
     */
    void rotateClockwise(int x, int y) {
        this.table[x][y].rotateClockwise();
    }

    /**
     * rotate's the subBoard[x][y] counter clockwise
     * @param x a row number for subBoard
     * @param y a column number for subBoard
     */
    void rotateCounterClockwise(int x, int y) {
        table[x][y].rotateCounterClockwise();
    }

    /**
     * this method is used for printing the table of the game.
     * first information about each player
     * then information about table
     * @param game is the actual game that want's to print it's table
     */
    void print(Game game) {
        System.out.println(ANSI_CYAN + "In this game sub tables are number from 1 to 4 clockwise starting from top left." + ANSI_RESET);
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

    /**
     *
     * @param game is the Game that asked for checking the table for finishing the game
     * @return true if the game has a winner and at time will set the winner boolean of isWinner to true
     * i checked all 4 possible patterns of finishing the game.
     */
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