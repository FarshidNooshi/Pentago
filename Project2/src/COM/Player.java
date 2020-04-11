package COM;

import java.util.Scanner;

public abstract class Player {
    private Cell playerCell;
    private boolean isWinner;
    private int id;

    Player(int id) {
        this.id = id;
        isWinner = false;
        playerCell = new Cell(id);
    }

    public int getId() {
        return id;
    }

    Cell getPlayerCell() {
        return playerCell;
    }

    void setWinner() {
        isWinner = true;
    }

    boolean isWinner() {
        return isWinner;
    }

    public abstract boolean move(Game game, Scanner scanner);
}
