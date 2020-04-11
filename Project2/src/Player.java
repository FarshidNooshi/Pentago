public abstract class Player {
    private Cell playerCell;

    public Cell getPlayerCell() {
        return playerCell;
    }

    public void setPlayerCell(Cell playerCell) {
        this.playerCell = playerCell;
    }

    public abstract void move();
}
