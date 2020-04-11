package COM;

import java.util.Scanner;

public class Game implements ColorfulText {

    private int numberOfPlayers;
    private Player[] player;
    private Board board;

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

    Board getBoard() {
        return board;
    }

    Player getPlayer(int id) {
        return this.player[id];
    }

    int getNumberOfPlayers() {
        return numberOfPlayers;
    }

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

    void clr() {
        for (int i = 0; i < 25; i++)
            System.out.println();
    }

    private void end() {
        System.out.println(ANSI_CYAN + "List of Players" + ANSI_RESET);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print(player[i].getPlayerCell().getColor() + "Player " + (i + 1) + " ");
            if (player[i].isWinner())
                System.out.print(ANSI_YELLOW + winner);
            System.out.println(ANSI_RESET);
        }
    }
}
