package COM;

import java.util.Scanner;

public class Computer extends Player {

    public Computer(int x) {
        super(x);
    }

    @Override
    public boolean move(Game game, Scanner scanner) {
        return false;
    }
}
