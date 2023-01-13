package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenParityGame;
import hexlet.code.games.GreatestCommonDivisionGame;

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.print(
            """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                0 - Exit
                Your choice:\s"""
        );
        Scanner sc = new Scanner(System.in);
        int gameNumber = Integer.parseInt(sc.next());

        switch (gameNumber) {
            case 1 -> Cli.greet();
            case 2 -> EvenParityGame.play();
            case 3 -> CalculatorGame.play();
            case 4 -> GreatestCommonDivisionGame.play();
            default -> {
                return;
            }
        }
    }
}
