public class SubBoard {
    private Cell[][] subBoard;

    SubBoard() {
        subBoard = new Cell[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                subBoard[i][j] = new Cell();
    }

    public void rotateClockwise() {
        SubBoard tmp = new SubBoard();
        for (int i =0 ; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp.subBoard[i][j].set(this.get(i, j));
        subBoard[0][2].set(tmp.subBoard[0][0]);
        subBoard[1][2].set(tmp.subBoard[0][1]);
        subBoard[2][2].set(tmp.subBoard[0][2]);
        subBoard[0][1].set(tmp.subBoard[1][0]);
        subBoard[2][1].set(tmp.subBoard[1][2]);
        subBoard[0][0].set(tmp.subBoard[2][0]);
        subBoard[1][0].set(tmp.subBoard[2][1]);
        subBoard[2][0].set(tmp.subBoard[2][2]);
    }

    public void rotateCounterClockwise() {
        SubBoard tmp = new SubBoard();
        for (int i =0 ; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp.subBoard[i][j].set(this.get(i, j));
        subBoard[0][0].set(tmp.subBoard[0][2]);
        subBoard[1][0].set(tmp.subBoard[0][1]);
        subBoard[2][0].set(tmp.subBoard[0][0]);
        subBoard[0][1].set(tmp.subBoard[1][2]);
        subBoard[2][1].set(tmp.subBoard[1][0]);
        subBoard[0][2].set(tmp.subBoard[2][2]);
        subBoard[1][2].set(tmp.subBoard[2][1]);
        subBoard[2][2].set(tmp.subBoard[2][0]);
    }

    public Cell get(int x, int y) {
        return subBoard[x][y];
    }

    public void setXY(int x, int y, Cell tmp) {
        subBoard[x][y] = tmp;
    }
}
