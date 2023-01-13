package hexlet.code;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        System.out.print("""
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            0 - Exit
            Your choice:
        """);
        Scanner sc = new Scanner(System.in);
        int gameNumber = Integer.parseInt(sc.next());

        switch (gameNumber) {
            case 1 -> Cli.greet();
            case 2 -> EvenParityGame.play();
        }
    }
}
