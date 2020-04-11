// In The Name Of GOD
package COM;

import java.util.Scanner;

/**
 * abstract class for implementing player method and using
 */

public abstract class Player {
    private Cell playerCell;
    private boolean isWinner;
    private int id;

    /**
     * constructor of the class
     * @param id is the id of the player
     *           all of the id's are unique to players
     */
    Player(int id) {
        this.id = id;
        isWinner = false;
        playerCell = new Cell(id);
    }

    /**
     *
     * @return the cell that is uniquely dedicated to this player
     */
    Cell getPlayerCell() {
        return playerCell;
    }

    /**
     * set this player as the winner of the match
     */
    void setWinner() {
        isWinner = true;
    }

    /**
     *
     * @return the isWinner boolean of the player
     */
    boolean isWinner() {
        return isWinner;
    }

    /**
     *
     * @param game is the actual game
     * @param scanner is the scanner for getting the input
     * @return if the move was successful or not
     */
    public abstract boolean move(Game game, Scanner scanner);
}
