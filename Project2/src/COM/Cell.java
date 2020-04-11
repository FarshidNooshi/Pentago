// In The Name Of GOD
package COM;

/**
 * it's the cell class and is here for knowing each cells information.
 */

public class Cell implements ColorfulText {

    char type;
    int userNumber;

    /**
     * the constructor of a cell
     * @param userNumber say's that this cell belongs to which player. if it's -1 then it belongs to no one.
     */
    Cell(int userNumber) {
        this.userNumber = userNumber;
        if (userNumber == -1)
            type = empty;
        else
            type = users[userNumber];
    }


    /**
     *
     * @return the type of the cell using unicode texts in ColorfulText interface.
     */
    char getType() {
        return type;
    }

    /**
     *
     * @return appropriate color for the cell. each player has a unique color and empty cells are green btw.
     */
    String getColor() {
        if (userNumber == 1)
            return ANSI_BLUE;
        else if (userNumber == 0)
            return ANSI_RED;
        else if (userNumber == -1)
            return ANSI_GREEN;
        else if (userNumber == 2)
            return ANSI_YELLOW;
        else if (userNumber == 3)
            return ANSI_PURPLE;
        return ANSI_CYAN;
    }

    /**
     * this method simply prints a cell in it's appropriate color
     */
    void print() {
        System.out.print(getColor() + " " + type + ANSI_RESET);
    }

    /**
     *
     * @param obj is to checking for equality with
     * @return true if both objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell tmp = (Cell) obj;
        return tmp.type == type;
    }
}
