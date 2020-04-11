// In The Name Of GOD
public class Board implements ColorfulText { // should be tested if it isn't necessary it might be deleted
    private SubBoard[][] table;
    public Board() {
        table = new SubBoard[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                table[i][j] = new SubBoard();
    }

    public void print(boolean movable) {

    }

    public boolean hasWinner() {
        return true;
    }

}
