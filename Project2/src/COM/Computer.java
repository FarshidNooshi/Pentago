package COM;

import java.util.Scanner;

public class Computer extends Player {

    Computer(int x) {
        super(x);
    }

    @Override
    public boolean move(Game game, Scanner scanner) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 1; j++)
                for (int k = 0; k < 5; k++)
                    if (game.getBoard().getTable(i / 3, (j + k) / 3).get(i % 3, (j + k) % 3).userNumber < 1) {
                        if (game.getBoard().occupied(i, j + k)) continue;
                        game.getBoard().getTable(i / 3, (j + k) / 3).setXY(i % 3, (j + k) % 3, this.getPlayerCell());
                        game.getBoard().rotateClockwise(1 - i / 3, 0);
                        return true;
                    } else
                        break;
        }
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 1; i++)
                for (int k = 0; k < 5; k++)
                    if (game.getBoard().getTable((i + k) / 3, j / 3).get((i + k) % 3, j % 3).userNumber < 1) {
                        if (game.getBoard().occupied((i + k), j)) continue;
                        game.getBoard().getTable((i + k) / 3, j / 3).setXY((i + k) % 3, j % 3, this.getPlayerCell());
                        game.getBoard().rotateClockwise(0, 1 - (j / 3));
                        return true;
                    } else
                        break;
        }
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                if (!game.getBoard().occupied(i, j)) {
                    game.getBoard().getTable(i / 3, j / 3).setXY(i % 3, j % 3, this.getPlayerCell());
                    game.getBoard().rotateClockwise(0, 0);
                    return true;
                }
        return true;
    }
}

