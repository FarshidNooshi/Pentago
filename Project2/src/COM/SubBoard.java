package COM;

public class SubBoard {
    private Cell[][] subBoard;

    SubBoard() {
        subBoard = new Cell[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                subBoard[i][j] = new Cell(-1);
    }

    void rotateClockwise() {
        SubBoard tmp = new SubBoard();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp.subBoard[i][j] = new Cell(this.get(i, j).userNumber);
        this.setXY(0, 2, tmp.subBoard[0][0]);
        this.setXY(0, 1, tmp.subBoard[1][0]);
        this.setXY(0, 0, tmp.subBoard[2][0]);
        this.setXY(1, 2, tmp.subBoard[0][1]);
        this.setXY(1, 0, tmp.subBoard[2][1]);
        this.setXY(2, 2, tmp.subBoard[0][2]);
        this.setXY(2, 1, tmp.subBoard[1][2]);
        this.setXY(2, 0, tmp.subBoard[2][2]);
    }

    void rotateCounterClockwise() {
        SubBoard tmp = new SubBoard();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp.subBoard[i][j] = new Cell(this.get(i, j).userNumber);
        this.setXY(0, 0, tmp.subBoard[0][2]);
        this.setXY(1, 0, tmp.subBoard[0][1]);
        this.setXY(2, 0, tmp.subBoard[0][0]);
        this.setXY(0, 1, tmp.subBoard[1][2]);
        this.setXY(2, 1, tmp.subBoard[1][0]);
        this.setXY(0, 2, tmp.subBoard[2][2]);
        this.setXY(1, 2, tmp.subBoard[2][1]);
        this.setXY(2, 2, tmp.subBoard[2][0]);
    }

    Cell get(int x, int y) {
        return subBoard[x][y];
    }

    void setXY(int x, int y, Cell tmp) {
        subBoard[x][y] = tmp;
    }
}
