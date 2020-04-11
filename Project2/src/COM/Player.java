public abstract class Player {
    protected Cell playerCell;
    private boolean isWinner;
    protected int id;

    public Player(int id) {
        this.id = id;
        isWinner = false;
        playerCell = new Cell(id);
    }

    public Cell getPlayerCell() {
        return playerCell;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setPlayerCell(Cell playerCell) {
        this.playerCell = playerCell;
    }

    public abstract void move();
}
