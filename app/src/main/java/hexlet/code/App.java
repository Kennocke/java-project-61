package hexlet.code;

import hexlet.code.games.PrimeNumberGame;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.GreatestCommonDivisionGame;
import hexlet.code.games.ArithmeticProgressionGame;
import hexlet.code.games.EvenParityGame;

import java.util.Scanner;
public class App {
    enum Games {
        Exit,
        Greet,
        Even,
        Calc,
        GCD,
        Progression,
        Prime
    }
    public static void main(String[] args) throws Exception {
        System.out.print(
            """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s"""
        );
        Scanner sc = new Scanner(System.in);
        int gameNumber = Integer.parseInt(sc.next());
        Games gameName = getNameGame(gameNumber);

        switch (gameName) {
            case Greet -> Cli.greet();
            case Even -> EvenParityGame.play();
            case Calc -> CalculatorGame.play();
            case GCD -> GreatestCommonDivisionGame.play();
            case Progression -> ArithmeticProgressionGame.play();
            case Prime -> PrimeNumberGame.play();
            default -> {
                return;
            }
        }
    }
    public static Games getNameGame(int gameNumber) throws Exception {
        Games[] games = Games.values();
        if (gameNumber < 0 || gameNumber >= games.length) {
            throw new Exception("Unknown game");
        }

        return games[gameNumber];
    }
}
