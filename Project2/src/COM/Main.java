// In The Name Of GOD
package COM;

import java.util.Scanner;

public class Main implements ColorfulText {

    /**
     *
     * the main method of the project that runs the game.
     */
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "HELLO");
        System.out.println("Welcome to the Pentago game\nI'm Farshid, Developer of this app\n");
        System.out.print("Please enter your preferred number of players: ");
        Scanner scanner = new Scanner(System.in);
        int tmp1 = scanner.nextInt();
        System.out.println("Now select if you want to play against computer or not? [y]yes [n]no");
        boolean tmp2 = (boolean)(scanner.next().charAt(0) == 'n');
        System.out.println("In this game sub tables are number from 1 to 4 clockwise starting from top left." + ANSI_RESET);
        Game game = new Game(tmp1, tmp2);
        game.start(scanner);
    }
}
