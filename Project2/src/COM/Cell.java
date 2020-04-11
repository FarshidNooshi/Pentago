package COM;

public class Cell implements ColorfulText {

    char type;
    int userNumber;

    Cell(int userNumber) {
        this.userNumber = userNumber;
        if (userNumber == -1)
            type = empty;
        else
            type = users[userNumber];
    }

    char getType() {
        return type;
    }

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

    void print() {
        System.out.print(getColor() + " " + type + ANSI_RESET);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell tmp = (Cell) obj;
        return tmp.type == type;
    }
}
