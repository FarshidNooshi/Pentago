import java.util.Scanner;

public class Human extends Player implements ColorfulText {

    public Human(int x) {
        super(x);

    }

    @Override
    public void move() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(ANSI_CYAN + "Please enter a cell to fill for your user: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if ()
    }
}
