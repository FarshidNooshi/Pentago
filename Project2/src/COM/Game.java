import java.util.Scanner;

public class Game implements ColorfulText{

    private int numberOfPlayers;
    private boolean isMultiMode;
    private Player[] player;
    private Board board;

    public Game(int numberOfPlayers, boolean isMultiMode) {
        this.numberOfPlayers = numberOfPlayers;
        this.isMultiMode = isMultiMode;
        player = new Player[numberOfPlayers];
        if (!isMultiMode)
            player[0] = new Computer(0);
        else
            player[0] = new Human(0);
        for (int i = 1; i < numberOfPlayers; i++)
            player[i] = new Human(i);
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer(int id) {
        return this.player[id];
    }

    public void setPlayer(int id, Player player) {
        this.player[id] = player;
    }

    public void start() {
        int ptr = 0;
        for (int i = 0; i < 36 && !board.hasWinner();i ++) {
            clr();
            board.print(true);
            player[ptr++ % numberOfPlayers].move();
        }
        clr();
        board.print(false);
        this.end();
    }

    private void clr() {
        for (int i = 0; i < 25; i++)
            System.out.println();
    }

    private void end() {
        System.out.println(ANSI_CYAN + "List of Players" + ANSI_RESET);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print(player[i].isWinner() ? ANSI_YELLOW : ANSI_GREEN);
            System.out.print("Player " + (i + 1) + " ");
            if (player[i].isWinner())
                System.out.print(winner);
            System.out.println(ANSI_RESET);
        }
    }
}
