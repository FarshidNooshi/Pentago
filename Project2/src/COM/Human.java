package COM;

import java.util.Scanner;

public class Human extends Player implements ColorfulText {

    Human(int x) {
        super(x);
    }

    @Override
    public boolean move(Game game, Scanner scanner) {
        System.out.print(this.getPlayerCell().getColor() + "Please enter a cell to fill for your user: ");
        int row = scanner.nextInt() - 1;
        int column = scanner.nextInt() - 1;
        if (row < 0 || row > 5 || column < 0 || column > 5 || game.getBoard().occupied(row, column)) {
            System.out.println("Try again" + ANSI_RESET);
            return false;
        }
        game.clr();
        game.getBoard().getTable(row / 3, column / 3).setXY(row % 3, column % 3, this.getPlayerCell());
        game.getBoard().print(game);
        System.out.print(this.getPlayerCell().getColor() + "Please enter one table to rotate: ");
        int number = scanner.nextInt() - 1;
        System.out.print("now a direction: " + ANSI_BLUE + "1 = " + clockwise + ANSI_RED + " 2 = " + counterClockwise + ANSI_CYAN);
        int dir = scanner.nextInt();
        if (dir == 1)
            game.getBoard().rotateClockwise(number / 2, number % 2);
        else
            game.getBoard().rotateCounterClockwise(number / 2, number % 2);
        System.out.println(ANSI_RESET);
        return true;
    }
}
