public class Cell implements ColorfulText {

    char type;
    int userNumber;

    public Cell(int userNumber) {
        this.userNumber = userNumber;
        if (userNumber == -1)
            type = empty;
        else
            type = users[userNumber];
    }

    public void set(Cell x) {
        this.type = x.type;
        this.userNumber = x.userNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell tmp = (Cell) obj;
        return tmp.type == type;
    }
}
