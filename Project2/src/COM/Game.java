// In The Name Of GOD
package COM;

import java.util.Scanner;

/**
 * this class is the game class and contains the information of the game such as player board.
 * I discuss about each method for itself if you need any info about methods read their docs.
 */

public class Game implements ColorfulText {

    private int numberOfPlayers;
    private Player[] player;
    private Board board;

    /**
     * it's the constructor of the class
     * @param numberOfPlayers is the number of players who involved in the game
     * @param isMultiMode if true then the game is not with human
     */
    Game(int numberOfPlayers, boolean isMultiMode) {
        board = new Board();
        this.numberOfPlayers = numberOfPlayers;
        player = new Player[numberOfPlayers];
        if (!isMultiMode)
            player[0] = new Computer(0);
        else
            player[0] = new Human(0);
        for (int i = 1; i < numberOfPlayers; i++)
            player[i] = new Human(i);
    }

    /**
     *
     * @return the board of the game
     */
    Board getBoard() {
        return board;
    }

    /**
     *
     * @param id is the id of the player who we wanna get
     * @return the player who's id is id
     */
    Player getPlayer(int id) {
        return this.player[id];
    }

    /**
     *
     * @return the number of players of the game
     */
    int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * this method is for starting the game and continues until the game end's then it call end method
     * @param scanner is the scanner of the game
     */
    void start(Scanner scanner) {
        for (int i = 0, ptr = 0; i < 36 && !board.hasWinner(this); i++) {
            clr();
            board.print(this);
            if (!player[ptr++ % numberOfPlayers].move(this, scanner))
                ptr--;
            ptr %= numberOfPlayers;
        }
        clr();
        board.print(this);
        end();
    }

    /**
     * this method will clear the console using empty lines
     */
    void clr() {
        for (int i = 0; i < 25; i++)
            System.out.println();
    }

    /**
     * this method is for ending the process and saying who won the game or the game ends in tie
     */
    private void end() {
        System.out.println(ANSI_CYAN + "List of Players" + ANSI_RESET);
        boolean isTie = true;
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print(player[i].getPlayerCell().getColor() + "Player " + (i + 1) + " ");
            if (player[i].isWinner()) {
                System.out.print(ANSI_YELLOW + winner);
                isTie = false;
            }
            System.out.println(ANSI_RESET);
        }
        if (isTie)
            System.out.println(ANSI_BLACK + "Game ends in tie" + ANSI_RESET);
    }
}
