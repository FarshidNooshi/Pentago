import java.util.Scanner;

public class Main {
    public static Game game;

    public static void main(String[] args) {
        System.out.println("HELLO");
        System.out.println("Welcome to the Pentago game\nI'm Farshid, Developer of this app\n");
        System.out.print("Please enter your preferred number of players: ");
        Scanner scanner = new Scanner(System.in);
        int tmp1 = scanner.nextInt();
        System.out.println("Now select if you want to play against computer or not? [y]yes [n]no");
        boolean tmp2 = (boolean)(scanner.next().charAt(0) == 'n');
        game = new Game(tmp1, tmp2);
        scanner.close();
        game.start();
    }
}
