// In The Name Of GOD
package COM;

/**
 * it's the subBoard class
 * additional information are available in board class
 */
class SubBoard {
    private Cell[][] subBoard;

    /**
     * each subBoard contains a 3*3 table of cells
     * constructor for the class
     * initially all the cells are empty
     */
    SubBoard() {
        subBoard = new Cell[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                subBoard[i][j] = new Cell(-1);
    }

    /**
     * used for rotating clockwise in the game
     * implementation of subBoard is for smoothly using clockwise and counterClockWise rotations.
     */
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

    /**
     * used for rotating counter clockwise in the game
     * implementation of subBoard is for smoothly using clockwise and counterClockWise rotations.
     */
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

    /**
     * @param x is a row number in subBoard
     * @param y is a column number in subBoard
     * @return the appropriate cell in [x][y]
     */
    Cell get(int x, int y) {
        return subBoard[x][y];
    }

    /**
     * @param x   is a row number in subBoard
     * @param y   is a column number in subBoard
     * @param tmp is a cell to replace in [x][y]
     */
    void setXY(int x, int y, Cell tmp) {
        subBoard[x][y] = tmp;
    }
}
