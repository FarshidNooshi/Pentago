// In The Name Of GOD
package COM;

import java.util.Scanner;

/**
 * this class extends player class for playing as a computer
 * my computer class uses a greedy algorithm to win
 */

public class Computer extends Player {

    Computer(int x) {
        super(x);
    }

    /**
     * the Greedy algorithm is as follows :
     * checking for free spaces in a row to win and if it finds some it will rotate an inappropriate subBoard and sellecting that cell for itself
     * if it doesn't find a good row it will search for a good column
     * after these two it will select a random non occupied place in the table
     * @param game is the actual game
     * @param scanner is the scanner for getting the input
     * @return true always cuz the move is always successful
     */
    @Override
    public boolean move(Game game, Scanner scanner) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 1; j++)
                for (int k = 0; k < 5; k++)
                    if (game.getBoard().getTable(i / 3, (j + k) / 3).get(i % 3, (j + k) % 3).userNumber < 1) {
                        if (game.getBoard().occupied(i, j + k)) continue;
                        game.getBoard().getTable(i / 3, (j + k) / 3).setXY(i % 3, (j + k) % 3, this.getPlayerCell());
                        game.getBoard().rotateClockwise(1 - i / 3, 0);
                        return true;
                    } else
                        break;
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 1; i++)
                for (int k = 0; k < 5; k++)
                    if (game.getBoard().getTable((i + k) / 3, j / 3).get((i + k) % 3, j % 3).userNumber < 1) {
                        if (game.getBoard().occupied((i + k), j)) continue;
                        game.getBoard().getTable((i + k) / 3, j / 3).setXY((i + k) % 3, j % 3, this.getPlayerCell());
                        game.getBoard().rotateClockwise(0, 1 - (j / 3));
                        return true;
                    } else
                        break;
        }
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (!game.getBoard().occupied(i, j)) {
                    game.getBoard().getTable(i / 3, j / 3).setXY(i % 3, j % 3, this.getPlayerCell());
                    game.getBoard().rotateClockwise(0, 0);
                    return true;
                }
        return true;
    }
}

